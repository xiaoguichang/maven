package com.xiaogch.maven.wechat.core.entity;

import com.xiaogch.maven.common.util.XmlDom4jUtil;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

/**
 * ProjectName: maven <BR>
 * File name: com.xiaogch.maven.wechat.core.entity <BR>
 * Author: guich <BR>
 * Project: maven <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/8/30 13:50 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class AccessTokenEntitiyTest {

    @Test
    public void testToString() {
        AccessTokenEntitiy accessTokenEntitiy = new AccessTokenEntitiy();
        accessTokenEntitiy.setAccessToken("1234567");
        accessTokenEntitiy.setAppId("appId");
        Long ct = System.currentTimeMillis();
        accessTokenEntitiy.setCreateTimestamp(ct);
        accessTokenEntitiy.setExpiresIn(7200);
        accessTokenEntitiy.setExpireTimeStamp(ct + 7200*1000);
        System.out.println(accessTokenEntitiy.toString());
    }

}