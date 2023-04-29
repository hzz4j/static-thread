package org.hzz;

import java.util.concurrent.TimeUnit;
public class MyFactory {
    private static Object lock = new Object();
    static{
        init();
//        new Thread(()->init()).start();
    }

    private static void init(){
        new Thread(()->{
            try {
                // make this thread run after main thread
                TimeUnit.SECONDS.sleep(3);
                System.out.println("task run...");
                synchronized (lock){
                    lock.notifyAll();  // notify main thread
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"demo-thread").start();

        synchronized (lock){
            try {
                System.out.println("waiting...");
                lock.wait();  // wait
                System.out.println("wake up");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static Object getSomething(){
        return null;
    }
}
