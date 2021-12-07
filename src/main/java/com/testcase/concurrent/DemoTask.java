package com.testcase.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2021-12-07
 * Time: 09:47
 */
public class DemoTask implements Runnable {

    private CountDownLatch latch;

    private Integer wait;

    public DemoTask(CountDownLatch latch, Integer wait) {
        this.latch = latch;
        this.wait = wait;
    }

    @Override
    public void run() {
        try {
            System.out.println("开始等待" + wait + "毫秒");
            Thread.sleep(wait);
            System.out.println("完成等待" + wait + "毫秒");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }

    }

}
