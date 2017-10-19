package com.xiaogch.maven.wechat.web;

import com.xiaogch.maven.common.util.MessageDigestUtil;
import com.xiaogch.maven.common.util.XmlDom4jUtil;
import com.xiaogch.maven.wechat.common.message.dto.ReceivedMsgDto;
import com.xiaogch.maven.wechat.config.WechatConfig;
import com.xiaogch.maven.wechat.core.service.MessageConsumeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

@RestController
public class WechatServiceController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WechatConfig wechatConfig;

    @Autowired
    private MessageConsumeService messageConsumeService;

    /**
     * 微信服务认证，用于微信公众号的接入
     * 开发者通过检验signature对请求进行校验，加密/校验流程如下：<br/>
     *  1）将token、timestamp、nonce三个参数进行字典序排序<br/>
     *  2）将三个参数字符串拼接成一个字符串进行sha1加密<br/>
     *  3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     * @param request
     * @param response
     * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @param echostr 随机字符串
     * @return 验证成功返回echostr ，否则返回空字符串
     */
    @RequestMapping(value = "/wechat/service" , method = RequestMethod.GET)
    public String validate(HttpServletRequest request , HttpServletResponse response ,
                        @RequestParam(value = "signature") String signature,
                        @RequestParam(value = "timestamp") String timestamp,
                        @RequestParam(value = "nonce") String nonce,
                        @RequestParam(value = "echostr") String echostr) {
        logger.info("request from WeiXin Server signature={} , timestamp={} , nonce={} , echostr={}" ,
                signature , timestamp , nonce, echostr);

        String[] arr = new String[]{wechatConfig.getToken() , timestamp , nonce };
        Arrays.sort(arr);
        StringBuilder builder = new StringBuilder();
        for (String tmp : arr) {
            builder.append(tmp);
        }

        try {
            String factSignature = MessageDigestUtil.sha1(builder.toString());
            boolean isSuccess = signature.equalsIgnoreCase(factSignature);
            logger.info("signature={} , factSignature={} , isSuccess={}" , signature , factSignature , isSuccess);
            if (isSuccess) {
                return echostr;
            }
        } catch (Exception e) {
           logger.error("validate wechat service excption" , e);
        }
        return "";
    }

    @RequestMapping(value = "/wechat/service" , method = RequestMethod.POST)
    public String service(HttpServletRequest request , HttpServletResponse response) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            logger.info(" request data is {}" , sb);

            //ReceivedMsgEntity receivedMsgEntity = XmlDom4jUtil.praseToBean(request.getInputStream() , ReceivedMsgEntity.class);
            ReceivedMsgDto receivedMsgDto = XmlDom4jUtil.praseToBean(new ByteArrayInputStream(sb.toString().getBytes()), ReceivedMsgDto.class);

            return messageConsumeService.consume(receivedMsgDto);
        } catch (Exception e) {
            logger.error("parse the message from weixin server exception" , e);
        }
        return "";
    }
}
