package com.xiaogch.maven.common.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ByteUtilTest {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void long2Byte() throws Exception {
        logger.info(MessageDigestUtil.md5("123456"));

//       byte[] result = ByteUtil.long2Byte(19999999990l);
//       assertEquals(19999999990l , ByteUtil.bytes2Long(result));
//
//       logger.info("80090l hex is :  {}" , ByteUtil.encodeHex(result));
//       loggergger.info("80090l hex is (system):  {}" , Long.toHexString(19999999990l));
    }

}