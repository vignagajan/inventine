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

    public boolean setPayoutId(String payoutId) {

        this.validator.setTxt(payoutId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.payoutId = payoutId;
            return true;
        }

        return false;
    }

    public int getAmount() {
        return amount;
    }

    public boolean setAmount(int amount) {

        if (amount >= 0) {
            this.amount = amount;
            return true;
        }
        return false;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public boolean setTransactionId(String transactionId) {

        this.validator.setTxt(transactionId);
        this.validator.setMaxLength(20);

        if (this.validator.isNumber()) {
            this.transactionId = transactionId;
            return true;
        }

        return false;

    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public boolean setCreatedAt(Timestamp createdAt) {

        try {
            this.createdAt = createdAt;

        } catch (Exception e) {
            return true;
        }

        return false;
    }
}
