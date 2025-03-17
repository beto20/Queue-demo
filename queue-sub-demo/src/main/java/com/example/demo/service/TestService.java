package com.example.demo.service;

import com.example.demo.configuration.GrpcConfiguration;
import com.example.demo.dto.MessageDto;
import com.example.sub.MessageResponse;
import com.example.sub.MessageServiceGrpc;
import com.google.protobuf.Empty;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final MessageServiceGrpc.MessageServiceBlockingStub blockingStub;

    public TestService() {
        this.blockingStub = MessageServiceGrpc.newBlockingStub(GrpcConfiguration.init());
    }

    public MessageDto invoke() {
//        blockingStub = MessageServiceGrpc.newBlockingStub(GrpcConfiguration.init());

        MessageResponse response = blockingStub.receiveMessageMethod(Empty.newBuilder().build());

        var message = new MessageDto();
        message.setBody(response.getBody());
        message.setHeader(response.getHeader());
        message.setPriority(response.getPriority());

        return message;
    }
}
