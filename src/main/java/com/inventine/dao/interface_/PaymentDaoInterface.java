package com.inventine.dao.interface_;

import com.inventine.model.Payment;

import java.util.List;

public interface PaymentDaoInterface{

    public boolean create(Payment payment);

    public Payment getPayment(String paymentId);

    public List<Payment> getAllPayment();

    public boolean update(Payment payment);

}