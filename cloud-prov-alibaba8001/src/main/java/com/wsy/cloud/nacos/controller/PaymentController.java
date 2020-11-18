package com.wsy.cloud.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/nacos")
    public String getPayment(@RequestParam Integer id){
        return "nacos registry,serverPort:" + serverPort + "\t id" +id;
    }
}
