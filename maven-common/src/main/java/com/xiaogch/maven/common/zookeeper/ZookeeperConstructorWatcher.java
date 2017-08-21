package com.xiaogch.maven.common.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.concurrent.CountDownLatch;

public class ZookeeperConstructorWatcher implements Watcher {

    Logger logger = LoggerFactory.getLogger(getClass());

    private CountDownLatch countDownLatch;

    public ZookeeperConstructorWatcher(CountDownLatch countDownLatch) {
        Assert.notNull(countDownLatch , "countDownLatch con't be null");
        this.countDownLatch = countDownLatch;

    }

    public void process(WatchedEvent watchedEvent) {
        logger.info("envent recieve , event info is path={} , state={} , type={}" , watchedEvent.getPath() , watchedEvent.getState() , watchedEvent.getType());
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            countDownLatch.countDown();
        }
    }
}
