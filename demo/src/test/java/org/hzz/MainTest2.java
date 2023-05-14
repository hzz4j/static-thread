package org.hzz;

public class MainTest2 {

    static {
        new Thread(MainHelper.task,"hzz-thread").start();
        System.out.println("current thread: " + Thread.currentThread().getName());
        try {
            MainHelper.latch.await();
            System.out.println("wake up");
        } catch (InterruptedException e) {}
    }
    public static void main(String[] args) {

    }
}
