package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniversityTest {
    University university;

    @BeforeEach
    void setUp() {
        this.university = new University();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/University.csv", numLinesToSkip = 1)
    void getterSetter(String email) {

        this.university.setEmail(email);

        assertEquals(email, this.university.getEmail());

    }
}
