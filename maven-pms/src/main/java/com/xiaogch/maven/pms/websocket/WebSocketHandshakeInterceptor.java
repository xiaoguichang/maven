package com.xiaogch.maven.pms.websocket;

import com.xiaogch.maven.common.config.ConfigFactory;
import com.xiaogch.maven.system.entity.UserInfoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/11 10:35 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class WebSocketHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        logger.info("beforeHandshake {} , {}" , request , attributes);
        ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
        HttpSession session = servletRequest.getServletRequest().getSession(false);
        if (session != null && ConfigFactory.getAuthConfig() != null) {
            //使用userName区分WebSocketHandler，以便定向发送消息
            UserInfoBean userInfoBean = (UserInfoBean) session.getAttribute(ConfigFactory.getAuthConfig().getUserInfo());
            logger.info("userInfoBean {}" , userInfoBean);
            if (userInfoBean != null) {
                attributes.put(ConfigFactory.getAuthConfig().getUserInfo() , userInfoBean);
                return super.beforeHandshake(request, response, wsHandler, attributes);
            }
        }
        return false;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        logger.info("beforeHandshake {} , {}" , request);
        super.afterHandshake(request, response, wsHandler, ex);
    }

}
