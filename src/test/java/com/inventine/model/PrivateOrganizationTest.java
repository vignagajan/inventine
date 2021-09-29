package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrivateOrganizationTest {
    PrivateOrganization privateOrganization;

    @BeforeEach
    void setUp() {
        this.privateOrganization = new PrivateOrganization();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/PrivateOrganization.csv", numLinesToSkip = 1)
    void getterSetter(String reg_no) {

        this.privateOrganization.setRegNo(reg_no);

        assertEquals(reg_no, this.privateOrganization.getRegNo());
    }
}
