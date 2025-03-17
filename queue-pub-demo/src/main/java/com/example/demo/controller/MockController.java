package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mock")
public class MockController {
    private final TestService testService;

    public MockController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    public String testEndpoint() {
        testService.invoke();
        return "Test";
    }
}
