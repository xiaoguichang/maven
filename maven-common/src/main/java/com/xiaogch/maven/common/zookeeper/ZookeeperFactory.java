package com.xiaogch.maven.common.zookeeper;

import com.xiaogch.maven.common.util.ByteUtil;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class ZookeeperFactory {

    static Logger logger = LoggerFactory.getLogger(ZookeeperFactory.class);

    public static ZooKeeper getInstance(String connectString , int sessionTimeout) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            ZooKeeper zooKeeper = new ZooKeeper(connectString , sessionTimeout , new ZookeeperConstructorWatcher(countDownLatch));
            logger.info("zookeeper client has create , state = {}" , zooKeeper.getState());
            countDownLatch.await();
            logger.info("zookeeper session has establish , state = {}" , zooKeeper.getState());

            logger.info("sessionId={} , password={}"  , zooKeeper.getSessionId() , ByteUtil.encodeHex(zooKeeper.getSessionPasswd()));
            return zooKeeper;
        } catch (Exception e) {
            logger.error("create zookeeper session exception" , e);
            return null;
        }
    }
}
