package com.xiaogch.maven.wechat.core.entity;

import com.xiaogch.maven.common.util.XmlDom4jUtil;
import com.xiaogch.maven.wechat.common.core.dto.AccessTokenDto;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/8/30 13:50 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class AccessTokenDtoTest {

    @Test
    public void testToString() {
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setAccessToken("1234567");
        accessTokenDto.setAppId("appId");
        Long ct = System.currentTimeMillis();
        accessTokenDto.setCreateTimestamp(ct);
        accessTokenDto.setExpiresIn(7200);
        accessTokenDto.setExpireTimeStamp(ct + 7200*1000);
        System.out.println(accessTokenDto.toString());
    }

}