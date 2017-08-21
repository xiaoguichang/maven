package com.xiaogch.maven.common.util;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.junit.Assert.*;

public class ByteUtilTest {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void long2Byte() throws Exception {
       byte[] result = ByteUtil.long2Byte(19999999990l);
       assertEquals(19999999990l , ByteUtil.bytes2Long(result));

       logger.info("80090l hex is :  {}" , ByteUtil.encodeHex(result));
       logger.info("80090l hex is (system):  {}" , Long.toHexString(19999999990l));
    }

}