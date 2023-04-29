package org.hzz;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class MyFactory {
    private static Object lock = new Object();
    static{
        init();
    }

    private static void init(){
        new Thread(()->{
            try {
                // make this thread run after main thread
                TimeUnit.SECONDS.sleep(3);
                log.info("task run...");
                synchronized (lock){
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"demo-thread").start();

        synchronized (lock){
            try {
                log.info("waiting...");
                lock.wait();
                log.info("wake up");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static Object getSomething(){
        return null;
    }
}
