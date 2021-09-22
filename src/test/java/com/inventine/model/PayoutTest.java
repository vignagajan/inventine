package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class PayoutTest {
    Payout payout;

    @BeforeEach
    void setUp() {
        this.payout = new Payout();
    }



    @ParameterizedTest
    @CsvFileSource(resources = "/model/Payout.csv", numLinesToSkip = 1)
    void getterSetter(long amount, int transaction_id, Timestamp created_at) {

        this.payout.setAmount(amount);
        this.payout.setTransactionId(transaction_id);
        this.payout.setCreatedAt(created_at);


        assertEquals(amount,this.payout.getAmount());
        assertEquals(transaction_id,this.payout.getTransactionId());
        assertEquals(created_at,this.payout.getCreatedAt());




    }



}