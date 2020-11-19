package com.wsy.cloud.sentinel.controller;

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
    }    @GetMapping("/testB")
    public String getB(@RequestParam Long id){
        return "sentinelB" + id;
    }
}
