package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectTest {
    Project project;

    @BeforeEach
    void setUp() {
        this.project = new Project();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Project.csv", numLinesToSkip = 1)
    void getterSetter(String project_id, Timestamp created_at, char financial_status, char status, int requested_amount, Timestamp date_of_expiry) {

        this.project.setProjectId(project_id);
        this.project.setCreatedAt(created_at);
        this.project.setFinancialStatus(financial_status);
        this.project.setStatus(status);
        this.project.setRequestedAmount(requested_amount);
        this.project.setDateOfExpiry(date_of_expiry);

        assertEquals(project_id, this.project.getProjectId());
        assertEquals(created_at, this.project.getCreatedAt());
        assertEquals(financial_status, this.project.getFinancialStatus());
        assertEquals(status, this.project.getStatus());
        assertEquals(requested_amount, this.project.getRequestedAmount());
        assertEquals(date_of_expiry, this.project.getDateOfExpiry());
    }
}
