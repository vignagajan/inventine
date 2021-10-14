package com.inventine.dao;

import com.inventine.model.Organization;
import com.inventine.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationDaoImplementationTest {

    Organization organization;
    OrganizationDaoImplementation organizationDao;

    @BeforeEach
    void setUp() {
        this.organization = new Organization();
        this.organizationDao = new OrganizationDaoImplementation();


    }


    @ParameterizedTest
    @CsvFileSource(resources = "/model/Organization.csv", numLinesToSkip = 1)
    void create(String organization_Id,String creator_Id,String support_Team_Id, String name, String address , String district, String  contact_number,Timestamp created_at) {

        this.organization.setOrganizationId(organization_Id);
        this.organization.setCreatorId(creator_Id);
        this.organization.setSupportTeamId(support_Team_Id);
        this.organization.setName(name);
        this.organization.setAddress(address);
        this.organization.setDistrict(district);
        this.organization.setContactNumber(contact_number);
        this.organization.setCreatedAt(created_at);


        assertTrue(this.organizationDao.create(organization));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/model/Organization.csv", numLinesToSkip = 1)
    void getOrganization(String organization_Id,String creator_Id,String support_Team_Id, String name, String address , String district, String  contact_number) {

        this.organization = this.organizationDao.getOrganization(organization_Id);

        assertEquals(organization_Id, this.organization.getOrganizationId());
        assertEquals(creator_Id, this.organization.getCreatorId());
        assertEquals(support_Team_Id, this.organization.getSupportTeamId());
        assertEquals(name, this.organization.getName());
        assertEquals(address, this.organization.getAddress());
        assertEquals(contact_number, this.organization.getContactNumber());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Organization.csv", numLinesToSkip = 1)
    void getOrganizations(String organization_Id,String creator_Id,String support_Team_Id, String name, String address , String district, String  contact_number) {

        List<Organization> ls = this.organizationDao.getOrganizations();

        this.organization.setOrganizationId(organization_Id);
        this.organization.setCreatorId(creator_Id);
        this.organization.setSupportTeamId(support_Team_Id);
        this.organization.setName(name);
        this.organization.setAddress(address);
        this.organization.setDistrict(district);
        this.organization.setContactNumber(contact_number);


        assertEquals(ls.get(0).getOrganizationId(),this.organization.getOrganizationId());
        assertEquals(ls.get(0).getCreatorId(),this.organization.getCreatorId());
        assertEquals(ls.get(0).getSupportTeamId(),this.organization.getSupportTeamId());
        assertEquals(ls.get(0).getName(),this.organization.getName());
        assertEquals(ls.get(0).getAddress(),this.organization.getAddress());
        assertEquals(ls.get(0).getDistrict(),this.organization.getDistrict());
        assertEquals(ls.get(0).getContactNumber(),this.organization.getContactNumber());


    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Organization.csv", numLinesToSkip = 1)
    void update(String organization_Id,String creator_Id,String support_Team_Id, String name, String address , String district, String  contact_number) {

        this.organization.setOrganizationId(organization_Id);
        this.organization.setCreatorId("5");
        this.organization.setSupportTeamId("4");
        this.organization.setName(name);
        this.organization.setAddress(address);
        this.organization.setDistrict("jaffna");
        this.organization.setContactNumber(contact_number);


        this.organizationDao.update(this.organization);

        Organization updated = this.organizationDao.getOrganization(organization_Id);

        assertEquals(this.organization.getOrganizationId(),updated.getOrganizationId());
        assertEquals("5",updated.getCreatorId());
        assertEquals("4",updated.getSupportTeamId());
        assertEquals(this.organization.getName(),updated.getName());
        assertEquals(this.organization.getAddress(),updated.getAddress());
        assertEquals("jaffna",updated.getDistrict());
        assertEquals(this.organization.getContactNumber(),updated.getContactNumber());


    }



}