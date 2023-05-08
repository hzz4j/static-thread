package org.hzz;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MainTest {

    static {
        new Thread(()-> System.out.println("hello")).start();
        System.out.println("current thread: " + Thread.currentThread().getName());
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {}
    }
    public static void main(String[] args) {

    }
}
