package com.inventine.model;

import com.inventine.util.DataValidator;

import java.sql.Timestamp;

public class Payout {

    private String payoutId;
    private int amount;
    private String transactionId;
    private Timestamp createdAt;
    private DataValidator validator = new DataValidator();


    public String getPayoutId() {
        return payoutId;
    }

    public int setPayoutId(String payoutId) {

        this.validator.setTxt(payoutId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.payoutId = payoutId;
            return 1;
        }

        return 0;
    }

    public int getAmount() {
        return amount;
    }

    public int setAmount(int amount) {

        if (amount >= 0) {
            this.amount = amount;
            return 1;
        }
        return 0;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public int setTransactionId(String transactionId) {

        this.validator.setTxt(transactionId);
        this.validator.setMaxLength(20);

        if (this.validator.isNumber()) {
            this.transactionId = transactionId;
            return 1;
        }

        return 0;

    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public int setCreatedAt(Timestamp createdAt) {

        try {
            this.createdAt = createdAt;

        } catch (Exception e) {
            return 0;
        }

        return 1;
    }
}
