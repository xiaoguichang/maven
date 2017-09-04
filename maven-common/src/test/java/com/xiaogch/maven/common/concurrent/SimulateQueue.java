package com.xiaogch.maven.common.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class SimulateQueue {

    Logger logger = LoggerFactory.getLogger(getClass());

    private LinkedList<Object> list;
    private final int maxSize;
    private final int minSize;
    private AtomicInteger size = new AtomicInteger(0);
    private Object emptyLock = new Object();

    public SimulateQueue() {
        this(0 , 5);
    }

    public SimulateQueue(int minSize , int maxSize) {
        list = new LinkedList<>();
        this.maxSize = maxSize;
        this.minSize = minSize;
    }

    public int put(Object element) {
        synchronized (emptyLock) {
            while (size.get() >= maxSize) {
                try {
                    logger.info("{} , queue is full , can't put element to queue , waiting !" , Thread.currentThread().getName());
                    emptyLock.wait();
                    emptyLock.notifyAll();
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }
            list.add(element);
            size.incrementAndGet();
            emptyLock.notifyAll();
            logger.info("{} , queue add an element({}) successfull ,  notify other thread !" , Thread.currentThread().getName() , element);
            return size.get();
        }
    }

    public Object take() {
        synchronized (emptyLock) {
            while (size.get() <= minSize) {
                try {
                    logger.info("{} , queue is empty , can't take element from queue , waiting !" , Thread.currentThread().getName());
                    emptyLock.wait();
                    emptyLock.notifyAll();
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }
            Object result = list.removeFirst();
            size.decrementAndGet();
            logger.info("{} , queue take an element from queue successfull ,  notify other thread !" , Thread.currentThread().getName());
            emptyLock.notifyAll();
            return result;
        }
    }


    public static void main(String...argvs) {
        Logger log = LoggerFactory.getLogger(SimulateQueue.class);
        SimulateQueue queue = new SimulateQueue();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for ( ; ; ) {
                    log.info("{} , add element to quque success size {} " , Thread.currentThread().getName() , queue.put(new Object()));
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        Thread.interrupted();
                    }
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                for ( ; ; ) {
                    log.info("{} , get element form queue {} " , Thread.currentThread().getName() , queue.take());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.interrupted();
                    }
                }
            }
        };

        Thread putThread1 = new Thread(runnable , "putThread 1");
        Thread putThread2 = new Thread(runnable , "putThread 2");
        Thread takeThread1 = new Thread(runnable2 , "takeThread 1");
        Thread takeThread2 = new Thread(runnable2 , "takeThread 2");
        putThread1.start();
        putThread2.start();
        takeThread1.start();
        takeThread2.start();
    }



}
