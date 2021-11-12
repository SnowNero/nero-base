package com.testcase.lock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2019-09-03
 * Time: 14:36
 */
public class TestLockMain {

    private static TestLock testLock = new TestLock();

    public static void main(String[] args) throws Exception {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        fixedThreadPool.submit(new GetCallable("a"));
        Thread.sleep(1000);
        fixedThreadPool.submit(new GetCallable("a"));
        Thread.sleep(10000);
        fixedThreadPool.submit(new GetCallable("b"));
    }

    public static class GetCallable implements Callable {

        private String a;

        GetCallable(String a) {
            this.a = a;
        }

        @Override
        public Object call() throws Exception {
            String str = testLock.getValue(a);
            System.out.println("key:" + a + "-value:" + str);
            return null;
        }
    }

}
