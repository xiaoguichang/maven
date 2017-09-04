package com.xiaogch.maven.common.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class NotifyWaitThread {

    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String...argvsd) {
        Logger logger = LoggerFactory.getLogger(NotifyWaitThread.class);
        Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int index = 0 ; index < 10 ; index ++){
                        count.incrementAndGet();
                        logger.info("{} acount increase , count={}" , Thread.currentThread().getName() , count.get());
                        if (count.get() == 5) {
                            logger.info("{} send sign to notify other thread ..." , Thread.currentThread().getName());
                            lock.notify();
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.interrupted();
                        }

                    }
                }
            }
        } , "thread t1");


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    if (count.get() != 5) {
                        logger.info("{} wait for notify from other threads ...." , Thread.currentThread().getName());
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.interrupted();
                            e.printStackTrace();
                        }
                        logger.info("{} recieved notify from other threads ...." , Thread.currentThread().getName());
                    }

                }
            }
        } , "thread t2");

        t2.start();
        t1.start();
    }

}
