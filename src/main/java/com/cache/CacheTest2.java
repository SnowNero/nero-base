package com.cache;

/**
 * Created with IntelliJ IDEA.
 * Description:缓存行对齐解决数据的伪共享问题测试
 * 1、涉及mesi缓存一致性协议和多核CPU三级缓存、主内存加载数据。
 * 2、CPU从缓存中加载数据是以64byte为一个单元，叫缓存行。
 * 执行时间8785毫秒
 * User: nero
 * Date: 2023-06-13
 * Time: 10:39
 *
 * @author nero
 */
public class CacheTest2 {

    private static long count = 1_000_000_000L;

    private static class Data {
        //一个缓存行64byte,long类型8byte,左右各填满56byte即可
        private volatile long p0, p1, p2, p3, p4, p5, p6, p7;
        private volatile long value;

    }

    public static void main(String[] args) throws InterruptedException {
        Data[] arr = new Data[2];
        arr[0] = new Data();
        arr[1] = new Data();
        //两个线程分别做1亿次修改
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                arr[0].value = i;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                arr[1].value = i;
            }
        });
        long startTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "毫秒");
    }

}
