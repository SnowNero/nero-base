package com.testcase.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2019-11-30
 * Time: 18:17
 */
public class TestLock {

    private static ReentrantLock lock = new ReentrantLock();

    private static volatile Map<String, String> testMap = new HashMap();

    public void setValue(String a) throws Exception {
        //模拟存入
        Thread.sleep(5000);
        testMap.put(a, a);
    }


    public String getValue(String a) throws Exception {
        long threadId = Thread.currentThread().getId();
        String str = testMap.get(a);
        if (str == null) {
            System.out.println("线程" + threadId + "没有缓存数据，需要处理");
            lock.lock();
            System.out.println(lock.getHoldCount());
            str = testMap.get(a);
            if (str == null) {
                System.out.println("线程" + threadId + "开始处理缓存数据");
                setValue(a);
                System.out.println("线程" + threadId + "结束处理缓存数据");
                System.out.println(lock.getHoldCount());
                lock.unlock();
                System.out.println(lock.getHoldCount());
            } else {
                System.out.println("线程" + threadId + "已被别的线程放入缓存");
                lock.unlock();
                System.out.println(lock.getHoldCount());
            }
            str = testMap.get(a);
            return str;
        } else {
            System.out.println("线程" + threadId + "有缓存数据");
            return str;
        }
    }

}
