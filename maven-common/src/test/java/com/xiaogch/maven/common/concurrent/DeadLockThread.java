package com.xiaogch.maven.common.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeadLockThread {

    public static void main(String...argvs){
        Object lock1 = new Object();
        Object lock2 = new Object();
        Logger logger = LoggerFactory.getLogger(DeadLockThread.class);


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    logger.info("{} has got lock1 , try to get lock2" , Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.interrupted();
                    }
                    synchronized (lock2) {
                        logger.info("{} has got lock2" , Thread.currentThread().getName());
                    }
                }
            }
        } , "thread t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    logger.info("{} has got lock2 , try to get lock1" , Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.interrupted();
                    }
                    synchronized (lock1) {
                        logger.info("{} has got lock1" , Thread.currentThread().getName());
                    }
                }

            }
        } , "thread t2");

        t1.start();
        t2.start();
    }
}
