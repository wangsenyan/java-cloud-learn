package com.wsy.cloud.cons.controller;

import com.wsy.cloud.mbg.dto.CommonResult;
import com.wsy.cloud.mbg.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {
    public static final String PAYMENT_URL ="http://localhost:8001";
    /**
     * @Autowired默认按类型装配
     * @Resource 默认按名称进行装配
     */
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/create")
    public CommonResult create(Payment payment){
        /**
         * 请求路径,参数,返回类型
         * post传递的参数放在body中,需要使用@ResponseBody
         */
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/get")
    public CommonResult<Payment> getPayment(@RequestParam Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get?id="+id,CommonResult.class);
    }
}
