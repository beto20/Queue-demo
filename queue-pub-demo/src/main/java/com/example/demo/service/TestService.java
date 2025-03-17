package com.example.demo.service;

import com.example.demo.configuration.GrpcConfiguration;
import com.example.pub.MessageRequest;
import com.example.pub.MessageResponse;
import com.example.pub.MessageServiceGrpc;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final MessageServiceGrpc.MessageServiceBlockingStub blockingStub;

    public TestService() {
        this.blockingStub = MessageServiceGrpc.newBlockingStub(GrpcConfiguration.init());
    }

    public String invoke() {
//        blockingStub = MessageServiceGrpc.newBlockingStub(GrpcConfiguration.init());

        MessageRequest request = MessageRequest.newBuilder()
                .setBody("prueba")
                .setHeader("cabecera")
                .setPriority("HIGH_PRIORITY")
                .build();

        MessageResponse response = blockingStub.sendMessageMethod(request);

        return response.getResponse();
    }
}
