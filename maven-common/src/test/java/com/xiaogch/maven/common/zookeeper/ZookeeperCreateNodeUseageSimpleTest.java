package com.xiaogch.maven.common.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZookeeperCreateNodeUseageSimpleTest {

    Logger logger = LoggerFactory.getLogger(getClass());

    private String connectString= "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183" ;
    private int sessionTimeout = 60000;
    private ZooKeeper zooKeeper = ZookeeperFactory.getInstance(connectString , sessionTimeout);

    private ZookeeperCreateNodeUseageSimple simple;

    @Before
    public void init() {
        simple = new ZookeeperCreateNodeUseageSimple(zooKeeper);
    }

    @Test
    public void testSyncCreateNode() {
        logger.info("zooKeeper status is {}" , zooKeeper.getState());
        simple.syncCreateNode("/test/sync1" , "EPHEMERAL sync create node test case 1" , CreateMode.EPHEMERAL);
        simple.syncCreateNode("/test/sync2" , "EPHEMERAL_SEQUENTIAL sync create node test case 2" , CreateMode.EPHEMERAL_SEQUENTIAL);
        simple.syncCreateNode("/test/sync3" , "PERSISTENT sync create node test case 3" , CreateMode.PERSISTENT);
        simple.syncCreateNode("/test/sync4" , "PERSISTENT_SEQUENTIAL sync create node test case 4" , CreateMode.PERSISTENT_SEQUENTIAL);
    }

    @Test
    public void testAyncCreateNode() {
        simple.ayncCreateNode("/test/aync1" , "EPHEMERAL aync create node test case 1" , CreateMode.EPHEMERAL);
        simple.ayncCreateNode("/test/aync2" , "EPHEMERAL_SEQUENTIAL aync create node test case 2" , CreateMode.EPHEMERAL_SEQUENTIAL);
        simple.ayncCreateNode("/test/aync3" , "PERSISTENT aync create node test case 3" , CreateMode.PERSISTENT);
        simple.ayncCreateNode("/test/aync4" , "PERSISTENT_SEQUENTIAL aync create node test case 4" , CreateMode.PERSISTENT_SEQUENTIAL);

        try {
            Thread.sleep(2*60*1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}