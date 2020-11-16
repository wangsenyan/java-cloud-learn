package com.wsy.cloud.prov.service;

import com.wsy.cloud.mbg.model.Payment;

public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(Long id);
}
