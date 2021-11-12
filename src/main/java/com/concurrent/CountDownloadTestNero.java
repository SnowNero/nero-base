package com.concurrent;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2019-11-04
 * Time: 10:44
 */
public class CountDownloadTestNero {

    private static int testCount = 1;

    private static CountDownLatch latch = new CountDownLatch(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = testCount; i <= 10; i++) {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Future<String> res = executorService.submit(new TestRunnable(testCount));
            testCount++;
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完毕");
    }

    static class TestRunnable implements Callable {

        private int sleepCount;

        public TestRunnable() {
        }

        public TestRunnable(int sleepCount) {
            this.sleepCount = sleepCount;
        }

        @Override
        public String call() {
            long start = System.currentTimeMillis();
            try {
                Thread.sleep(sleepCount * 1000);
                System.out.println("等待" + sleepCount + "秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
                long end = System.currentTimeMillis();
                return Thread.currentThread().getName() + "线程耗时:" + (end - start);
            }
        }
    }

}
