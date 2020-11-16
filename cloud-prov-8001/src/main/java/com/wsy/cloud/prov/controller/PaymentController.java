package com.wsy.cloud.prov.controller;


import com.wsy.cloud.mbg.model.Payment;
import com.wsy.cloud.mbg.dto.CommonResult;
import com.wsy.cloud.prov.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/create")
    @ResponseBody
    public CommonResult create(@RequestBody Payment payment){
        System.out.println(payment);
       int result =  paymentService.create(payment);
       if(result>0){
           return new CommonResult(200,"插入成功",result);
       }else{
           return new CommonResult(444,"插入失败",null);
       }
    }
    @GetMapping("/get")
    @ResponseBody
    public CommonResult getPaymentById(@RequestParam Long id){
        Payment result = paymentService.getPaymentById(id);
        if(result != null)
            return  new CommonResult(200,"获取成功",result);
        else
            return  new CommonResult(444,"获取失败",null);
    }
}
