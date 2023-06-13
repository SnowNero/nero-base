package com.cache;

/**
 * Created with IntelliJ IDEA.
 * Description:缓存行对齐解决数据的伪共享问题测试
 * 1、涉及mesi缓存一致性协议和多核CPU三级缓存、主内存加载数据。
 * 2、CPU从缓存中加载数据是以64byte为一个单元，叫缓存行。
 * 执行时间25365毫秒
 * User: nero
 * Date: 2023-06-13
 * Time: 10:38
 *
 * @author nero
 */
public class CacheTest1 {
    private static long count = 1_000_000_000L;

    private static class Data {
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
