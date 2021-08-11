package com.inventine.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class DataValidatorTest {

    DataValidator validator;

    @BeforeEach
    void setUp() {
        this.validator = new DataValidator();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/util/DataValidator/isMatch.csv", numLinesToSkip = 1)
    void isMatch(String txt, String pattern, Boolean expected) {
        validator.setTxt(txt);
        assertEquals(expected,validator.isMatch(pattern));

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