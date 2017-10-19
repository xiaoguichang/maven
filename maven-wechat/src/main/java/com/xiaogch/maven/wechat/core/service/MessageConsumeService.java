package com.xiaogch.maven.wechat.core.service;


import com.xiaogch.maven.wechat.common.message.dto.ReceivedMsgDto;

public interface MessageConsumeService {
    String consume(ReceivedMsgDto receivedMsgDto);
}
