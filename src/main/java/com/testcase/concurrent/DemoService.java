package com.testcase.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2021-12-07
 * Time: 10:01
 */
public class DemoService {

    public void testConcurrent() {
        CountDownLatch latch = new CountDownLatch(10);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            Integer wait = r.nextInt(30000) + 30000;
            DemoTask task = new DemoTask(latch, wait);
            fixedThreadPool.execute(task);
        }
    }


    public static void main(String[] args) {
        Random r = new Random();
        Integer wait = r.nextInt(10000);
        System.out.println(wait);
    }
}
