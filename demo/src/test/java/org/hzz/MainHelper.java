package org.hzz;

import java.util.concurrent.CountDownLatch;

public class MainHelper {
    public static CountDownLatch latch = new CountDownLatch(1);

    public static Runnable task = ()-> {
        System.out.println("hello world");
        latch.countDown();
    };
}
