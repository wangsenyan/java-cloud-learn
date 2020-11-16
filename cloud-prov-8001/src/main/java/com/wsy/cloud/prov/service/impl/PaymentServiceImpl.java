package com.wsy.cloud.prov.service.impl;

import com.wsy.cloud.mbg.mapper.PaymentMapper;
import com.wsy.cloud.mbg.model.Payment;
import com.wsy.cloud.prov.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.insertSelective(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return  paymentMapper.selectByPrimaryKey(id);
    }
}
