package com.xiaogch.maven.common.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class ZookeeperCreateNodeUseageSimple {

    private ZooKeeper zooKeeper;

    Logger logger = LoggerFactory.getLogger(getClass());

    public ZookeeperCreateNodeUseageSimple(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    public void syncCreateNode(String path , String data , CreateMode createMode) {
        try {
            byte[] dataArray = data.getBytes("utf-8");
            List<ACL> aclList = ZooDefs.Ids.OPEN_ACL_UNSAFE;
            String result = zooKeeper.create(path , dataArray , aclList , createMode);
            logger.info("syncCreateNode path={} , data={} , createMode={} , result={}" , path , data , createMode , result);
        } catch (UnsupportedEncodingException e) {
            logger.error("system unsupported encoding utf-8 exception" , e);
        } catch (KeeperException e) {
            logger.error( "syncCreateNode exception", e);
        } catch (InterruptedException e) {
            logger.error( "syncCreateNode exception", e);
        }
    }


    public void ayncCreateNode(String path , String data , CreateMode createMode) {
        try {
            byte[] dataArray = data.getBytes("utf-8");
            List<ACL> aclList = ZooDefs.Ids.OPEN_ACL_UNSAFE;
            zooKeeper.create(path , dataArray , aclList , createMode , new CreateNodeCallback() , new ContextObj("context info"));

            logger.info("ayncCreateNode path={} , data={} , createMode={}" , path , data , createMode);
        } catch (UnsupportedEncodingException e) {
            logger.error("system unsupported encoding utf-8 exception" , e);
        }
    }


    class ContextObj {
        private String message;

        public ContextObj(String message){
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }
        @Override
        public String toString() {
            return "ContextObj{" +
                    "message='" + message + '\'' +
                    '}';
        }
    }

    class CreateNodeCallback implements AsyncCallback.StringCallback {

        /**
         *
         * @param rs return result code
         * @param path
         * @param context
         * @param name
         */
        public void processResult(int rs, String path, Object context, String name) {
            logger.info(" rs={} , path={} , context={} , s1={}" , rs , path, context, name);
        }
    }
}
