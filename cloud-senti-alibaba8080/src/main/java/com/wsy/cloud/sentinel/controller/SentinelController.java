package com.wsy.cloud.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wsy.cloud.sentinel.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/sentinel")
@RestController
public class SentinelController {

    @GetMapping("/testA")
    public String getA(@RequestParam Long id){
//        try {
//            TimeUnit.MILLISECONDS.sleep(800);
//            Thread.sleep(300);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //int age = 10/0;
        return "sentinelA" + id;
    }
    @GetMapping("/testB")
    @SentinelResource(value = "testB",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException")
    public String getB(@RequestParam Long id){
        return "sentinelB" + id;
    }

    //热点
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    @GetMapping("/testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "testhotkey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "testhotkey-----------------------------------------dfgdf";
    }
}
