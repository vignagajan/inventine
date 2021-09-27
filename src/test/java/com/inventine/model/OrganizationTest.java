package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrganizationTest {
    Organization organization;

    @BeforeEach
    void setUp() {
        this.organization = new Organization();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/organization.csv", numLinesToSkip = 1)
    void getterSetter(String organization_id, String name, String address , String district, String  contact_number) {

        this.organization.setOrganizationId(organization_id);
        this.organization.setName(name);
        this.organization.setAddress(address);
        this.organization.setDistrict(district);
        this.organization.setContactNumber(contact_number);


        assertEquals(organization_id, this.organization.getOrganizationId());
        assertEquals(name, this.organization.getName());
        assertEquals(address, this.organization.getAddress());
        assertEquals(district, this.organization.getDistrict());
        assertEquals(contact_number, this.organization.getContactNumber());
    }
}
