package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrganizationTest {
    Organization organization;

    @BeforeEach
    void setUp() {
        this.organization = new Organization();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/organization.csv", numLinesToSkip = 1)
    void getterSetter(String organization_Id, String creator_Id, String support_Team_Id, String name, String address , String district, String  contact_number, Timestamp created_at) {

        this.organization.setOrganizationId(organization_Id);
        this.organization.setCreatorId(creator_Id);
        this.organization.setSupportTeamId(support_Team_Id);
        this.organization.setName(name);
        this.organization.setAddress(address);
        this.organization.setDistrict(district);
        this.organization.setContactNumber(contact_number);
        this.organization.setCreatedAt(created_at);


        assertEquals(organization_Id, this.organization.getOrganizationId());
        assertEquals(creator_Id,this.organization.getCreatorId());
        assertEquals(support_Team_Id,this.organization.getSupportTeamId());
        assertEquals(name, this.organization.getName());
        assertEquals(address,this.organization.getAddress());
        assertEquals(district, this.organization.getDistrict());
        assertEquals(contact_number, this.organization.getContactNumber());
        assertEquals(created_at, this.organization.getCreatedAt());
    }
}
