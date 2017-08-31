package com.xiaogch.maven.wechat.core.service;

import com.xiaogch.maven.wechat.core.entity.ReceivedMsgEntity;

public interface MessageConsumeService {
    String consume(ReceivedMsgEntity receivedMsgEntity);
}
