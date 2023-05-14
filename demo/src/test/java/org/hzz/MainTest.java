package org.hzz;

import java.util.concurrent.CountDownLatch;

public class MainTest {

    private static CountDownLatch latch = new CountDownLatch(1);
    static {
        new Thread(()-> {
            System.out.println("hello world");
            latch.countDown();
        },"hzz-thread").start();
        System.out.println("current thread: " + Thread.currentThread().getName());
        try {
            latch.await();
            System.out.println("wake up");
        } catch (InterruptedException e) {}
    }
    public static void main(String[] args) {

    }
}
