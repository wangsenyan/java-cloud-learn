package com.wsy.cloud.sentinel.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wsy.cloud.mbg.dto.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444,"按客户自定义,global handlerException----1");
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444,"按客户自定义,global handlerException----2");
    }
}
