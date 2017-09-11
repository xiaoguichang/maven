package com.xiaogch.maven.springmvc.websocket;


import com.alibaba.fastjson.JSONObject;
import com.xiaogch.maven.springmvc.config.ConfigFactory;
import com.xiaogch.maven.system.entity.UserInfoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/11 10:03 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class WebSocketEndPoint extends TextWebSocketHandler {

    Logger logger = LoggerFactory.getLogger(getClass());

    private final ConcurrentHashMap<String, WebSocketSession> userMap = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        JSONObject responseJson = new JSONObject();
        responseJson.put("code" , "1");
        responseJson.put("message" , "连接已经建立");
        responseJson.put("data" , new JSONObject());
        logger.info("afterConnectionEstablished be called");
        if (ConfigFactory.getAuthConfig() != null) {
            UserInfoBean systemUserInfoBean = (UserInfoBean)session.getAttributes().get(ConfigFactory.getAuthConfig().getUserInfo());
            logger.info("afterConnectionEstablished {}" , systemUserInfoBean);
            if (systemUserInfoBean != null) {
                userMap.put(systemUserInfoBean.getUserName() , session);
                session.sendMessage(new TextMessage(responseJson.toJSONString()));
            } else {
                responseJson.put("code" , "0");
                responseJson.put("message" , "您未登录，连接中断请稍后再试！");
                session.sendMessage(new TextMessage(responseJson.toJSONString()));
                session.close();
            }
        } else {
            logger.info("afterConnectionEstablished can't get AuthConfig");
            responseJson.put("code" , "-1");
            responseJson.put("message" , "系统配置错误，连接中断");
            session.sendMessage(new TextMessage(responseJson.toJSONString()));
            session.close();
        }
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        super.handleMessage(session, message);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        JSONObject responseJson = new JSONObject();
        responseJson.put("code" , "1");
        responseJson.put("message" , "你好");
        responseJson.put("data" , new JSONObject());
        session.sendMessage(new TextMessage(responseJson.toJSONString()));
        //super.handleTextMessage(session, message);
    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        super.handlePongMessage(session, message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        if (ConfigFactory.getAuthConfig() != null) {
            UserInfoBean systemUserInfoBean = (UserInfoBean)session.getAttributes().get(ConfigFactory.getAuthConfig().getUserInfo());
            if (systemUserInfoBean == null) {
                userMap.remove(systemUserInfoBean.getUserName());
            }
        }
        super.afterConnectionClosed(session, status);
    }

    @Override
    public boolean supportsPartialMessages() {
        return super.supportsPartialMessages();
    }

    public void broadcast(final TextMessage message) throws Exception {
        Iterator<String> iterator = userMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            WebSocketSession webSocketSession = userMap.get(key);
            if (webSocketSession.isOpen()) {
                webSocketSession.sendMessage(message);
            }
        }
    }

}
