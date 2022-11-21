/*
package com.redis;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;

*/
/**
 * @author liuyang
 *//*

@Component
@Slf4j
public class RedisUtil {
    private static JedisCluster jedisCluster = null;
    private static JedisPool jedisPool = null;
    private static boolean clusterOn = false;

    @Value("${redis.ip}")
    private String redisIp;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.auth}")
    private String auth;
    @Value("${redis.cluster.on}")
    private boolean clusterOnVal;
    @Value("${redis.cluster.nodes}")
    private String clusterNodes;
    @Value("${redis.cluster.auth}")
    private String clusterAuth;


    */
/**
     * 将 key 的值设为 value ，当且仅当 key 不存在。
     * 若给定的 key 已经存在，则 SETNX 不做任何动作。
     * SETNX 是『SET if Not eXists』(如果不存在，则 SET)的简写。
     * <p>
     * 保存字符串到redis缓存，并且设置过期时间
     *
     * @param key      键
     * @param value    值
     * @param _seconds 过期时间
     * @return 1保存成功，否则保存失败
     *//*

    public Long setNXData(String key, String value, final Integer _seconds) {
        return (Long) jedisTemplate(key, null, value, null, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                long result = commands.setnx(key, (String) value);
                if (result == 1 && _seconds != null) {
                    commands.expire(key, _seconds);
                }
                return result;
            }
        });


    }

    */
/**
     * Redis保存字符串
     *
     * @param key
     * @param value
     *//*

    public void setData(String key, String value, Integer seconds) {
        jedisTemplate(key, null, value, seconds, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                return commands.set(key, (String) value);
            }
        });
    }

    */
/**
     * 递增
     *
     * @param key
     *//*

    public void incr(String key) {
        jedisTemplate(key, null, null, null, (commands, key1, field, value, seconds) -> commands.incr(key1));
    }

    */
/**
     * Redis保存MAP
     *
     * @param key
     * @param value
     * @param seconds
     *//*

    public void setMapData(String key, Map<String, String> value, Integer seconds) {
        jedisTemplate(key, null, value, seconds, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                return commands.hmset(key, (Map<String, String>) value);
            }
        });
    }

    */
/**
     * 获取字符串
     *
     * @param key
     * @return
     *//*

    public String getData(String key) {
        return (String) jedisTemplate(key, null, null, null, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                return commands.get(key);
            }
        });
    }


    */
/**
     * 获取ＭＡＰ
     *
     * @param key
     * @param field
     * @return
     *//*

    public String getData(String key, String field) {
        return (String) jedisTemplate(key, field, null, null, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                return commands.hget(key, field);
            }
        });
    }

    */
/**
     * 删除数据
     *
     * @param key
     *//*

    public void delData(String key) {
        jedisTemplate(key, null, null, null, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                return commands.del(key);
            }
        });

    }

    */
/**
     * 保存对象
     *
     * @param key
     * @param value
     *//*

    public void setObjectData(String key, Object value, Integer seconds) {
        jedisTemplate(key, null, value, seconds, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                if (clusterOn) {
                    return ((JedisCluster) commands).set(key.getBytes(), SerializeUtil.serialize(value));
                } else {
                    return ((Jedis) commands).set(key.getBytes(), SerializeUtil.serialize(value));
                }
            }
        });

    }

    */
/**
     * Redis sadd
     *
     * @param key
     * @param _seconds
     *//*

    public Long sadd(String key, Integer _seconds, String... member) {
        return (Long) jedisTemplate(key, null, null, null, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                long result = commands.sadd(key, member);
                if (result > 0 && _seconds != null) {
                    commands.expire(key, _seconds);
                }
                return result;
            }
        });
    }

    */
/**
     * Redis sismember
     *
     * @param key
     * @param member
     *//*

    public boolean sismember(String key, String member) {
        return (boolean) jedisTemplate(key, null, null, null, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                return commands.sismember(key, member);
            }
        });
    }

    */
/**
     * 获取对象
     *
     * @param key
     * @return
     *//*

    public Object getObjectData(String key) {
        byte[] bytes = (byte[]) jedisTemplate(key, null, null, null, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                if (clusterOn) {
                    return ((JedisCluster) commands).get(key.getBytes());
                } else {
                    return ((Jedis) commands).get(key.getBytes());
                }
            }
        });
        if (bytes != null) {
            Object ob = SerializeUtil.unserialize(bytes);
            return ob;
        }
        return null;
    }

    */
/**
     * 获取对象列表
     *
     * @param key
     * @return
     *//*

    public List<String> getStringList(String key) {
        return (List<String>) jedisTemplate(key, null, null, null, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                return commands.lrange(key, 0, -1);
            }
        });
    }

    */
/**
     * 获取对象列表
     *
     * @param key
     * @return
     *//*

    public List<Object> getObjectListData(String key) {

        List<Object> os = Lists.newArrayList();
        List<byte[]> bytes = (List<byte[]>) jedisTemplate(key, null, null, null, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                if (clusterOn) {
                    return ((JedisCluster) commands).lrange(key.getBytes(), 0, -1);
                } else {
                    return ((Jedis) commands).lrange(key.getBytes(), 0, -1);
                }
            }
        });
        if (bytes != null) {
            for (byte[] bs : bytes) {
                os.add(SerializeUtil.unserialize(bs));
            }
            return os;
        }
        return Collections.emptyList();
    }


    public Long setMapData(String key, String field, String value, Integer seconds) {
        return (long) jedisTemplate(key, field, value, seconds, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                return commands.hset(key, field, (String) value);
            }
        });
    }

    */
/**
     * 保存对象LIST 在list的队尾插入
     *
     * @param key
     * @param value
     *//*

    public void setObjectListData(String key, Object value) {
        setObjectListData(key, value, null);
    }

    */
/**
     * 保存对象LIST 在list的队尾插入,带有效时间
     *
     * @param key
     * @param value
     *//*

    public void setObjectListData(String key, Object value, Integer seconds) {
        jedisTemplate(key, null, value, seconds, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                if (clusterOn) {
                    return ((JedisCluster) commands).rpush(key.getBytes(), SerializeUtil.serialize(value));
                } else {
                    return ((Jedis) commands).rpush(key.getBytes(), SerializeUtil.serialize(value));
                }
            }
        });
    }


    */
/**
     * 删除对象列表 需重写对象的equals方法
     *
     * @param key
     * @return
     *//*

    public void lrem(String key, Object value) {
        jedisTemplate(key, null, value, null, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                if (clusterOn) {
                    return ((JedisCluster) commands).lrem(key.getBytes(), 0, SerializeUtil.serialize(value));
                } else {
                    return ((Jedis) commands).lrem(key.getBytes(), 0, SerializeUtil.serialize(value));
                }
            }
        });
    }


    public Set<String> getKeys(String key) {
        return (Set<String>) jedisTemplate(key, null, null, null, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                if (clusterOn) {
                    TreeSet<String> keys = new TreeSet<>();
                    Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();
                    for (String k : clusterNodes.keySet()) {
                        JedisPool jp = clusterNodes.get(k);
                        try (Jedis connection = jp.getResource();) {
                            keys.addAll(connection.keys(key));
                        }
                    }
                    return keys;
                } else {
                    return ((Jedis) commands).keys(key);
                }
            }
        });
    }

    */
/**
     * 单个增加地理位置的坐标
     *
     * @param key
     * @param lon    经度
     * @param lat    纬度
     * @param member 地区名称
     *//*

    public void geoAddOne(String key, final double lon, final double lat, String member) {
        jedisTemplate(key, null, member, null, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                String[] split = field.split(",");
                return commands.geoadd(key, lon, lat, (String) value);
            }
        });
    }


    */
/**
     * 简单查询-根据坐标、半径查询
     *//*

    public List<String> geoRadius(String key, final double lon, final double lat, final double radius, final GeoUnit geoUnit) {
        return (List<String>) jedisTemplate(key, null, null, null, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                List<GeoRadiusResponse> list = commands.georadius(key, lon, lat, radius, geoUnit);
                List<String> result = Lists.newArrayList();
                if (list != null && !list.isEmpty()) {
                    for (GeoRadiusResponse georadiu : list) {
                        String memberByString = georadiu.getMemberByString();
                        result.add(memberByString);
                    }
                }
                return result;
            }
        });
    }

    */
/**
     * 获取对象
     *
     * @param key
     * @return
     *//*

    public <T> List<T> getJSONArrayData(String key, Class<T> clazz) {
        String jsonString = (String) jedisTemplate(key, null, null, null, new Callback() {
            @Override
            public Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds) {
                return commands.get(key);
            }
        });
        if (StringUtils.isNotEmpty(jsonString)) {
            List<T> result = JSONSerializeUtil.parseArray(jsonString, clazz);
            return result;
        }
        return null;
    }

    public Object jedisTemplate(String key, String field, Object value, Integer seconds, Callback cb) {
        if (clusterOn) {
            Object result = cb.invoke(jedisCluster, key, field, value, seconds);
            if (seconds != null) {
                jedisCluster.expire(key, seconds);
            }
            return result;
        } else {
            try (Jedis jedis = jedisPool.getResource();) {
                Object result = cb.invoke(jedis, key, field, value, seconds);
                if (seconds != null) {
                    jedis.expire(key, seconds);
                }
                return result;
            }
        }
    }

    @PostConstruct
    public void initRedisPool() {
        RedisUtil.clusterOn = this.clusterOnVal;
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(5000);
            config.setMaxIdle(100);
            config.setMaxWaitMillis(500);
            config.setTestWhileIdle(true);
            config.setTimeBetweenEvictionRunsMillis(30 * 60 * 1000L);
            config.setSoftMinEvictableIdleTimeMillis(10 * 60 * 1000L);
            if (clusterOn) {
                Set<HostAndPort> cluster = new HashSet<>();
                String[] nodes = this.clusterNodes.split("[,;]");
                for (String node : nodes) {
                    String[] hostAndPort = node.split("[:]");
                    cluster.add(new HostAndPort(hostAndPort[0], Integer.parseInt(hostAndPort[1])));
                }
                if (StringUtils.isBlank(this.clusterAuth)) {
                    jedisCluster = new JedisCluster(cluster, config);
                } else {
                    jedisCluster = new JedisCluster(cluster, 1000, 1000, 1, this.clusterAuth, config);
                }
            } else {
                if (StringUtils.isBlank(this.auth)) {
                    jedisPool = new JedisPool(config, this.redisIp, this.port, 500);
                } else {
                    jedisPool = new JedisPool(config, this.redisIp, this.port, 500, this.auth);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("[redis]初始化Redis连接池异常 : " + e);
        }
    }

    @PreDestroy
    public void closeRedisPool() {
        if (jedisPool != null) {
            jedisPool.destroy();
        }
        if (jedisCluster != null) {
            Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();
            clusterNodes.forEach((name, node) -> node.destroy());
        }
    }

    interface Callback {
        Object invoke(JedisCommands commands, String key, String field, Object value, Integer seconds);
    }


}
*/
