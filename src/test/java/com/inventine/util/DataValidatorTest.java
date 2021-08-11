package com.inventine.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataValidatorTest {

    DataValidator validator;

    @BeforeEach
    void setUp() {
        this.validator = new DataValidator();
    }

    @Test
    void isMatch() {
        validator.setTxt("fsdfUGYHH5456456");
        assertTrue(validator.isMatch("a-zA-Z0-9"));
        assertFalse(validator.isString());
        assertFalse(validator.isSmall());
        assertFalse(validator.isCapital());
        assertFalse(validator.isNumber());
    }

    @Test
    void isSmall() {
        validator.setTxt("fsdff");
        assertTrue(validator.isString());
    }

    @Test
    void isCapital() {
        validator.setTxt("UDCDD");
        assertTrue(validator.isCapital());
    }

    @Test
    void isString() {
        validator.setTxt("UDCDDfvsf");
        assertTrue(validator.isString());
    }

    @Test
    void isNumber() {
        validator.setTxt("98561489");
        assertTrue(validator.isNumber());
    }
}