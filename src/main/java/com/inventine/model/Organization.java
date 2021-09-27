package com.inventine.model;

import com.inventine.util.DataValidator;

public class Organization {
    private String organizationId;
    private String name;
    private String address;
    private String district;
    private String contactNumber;
    private DataValidator validator = new DataValidator();

    public String getOrganizationId(){ return organizationId;}

    public boolean setOrganizationId(String organizationId) {
        this.validator.setTxt(organizationId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.organizationId = organizationId;
            return true;
        }

        return false;
    }

    public String getName(){return name;}

    public boolean setName(String name){
        this.validator.setTxt(name);
        this.validator.setMinLength(1);

        if (this.validator.isAlphaNumeric()) {
            this.name = name;
            return true;
        }

        return false;
    }

    public String getAddress(){return address;}

    public boolean setAddress(String address){
        this.validator.setTxt(address);
        this.validator.setMinLength(8);
        this.validator.setMaxLength(100);

        if (this.validator.isAlphaNumeric()) {
            this.address = address;
            return true;
        }

        return false;
    }

    public String getDistrict(){return district;}

    public boolean setDistrict(String district){
        this.validator.setTxt(district);
        this.validator.setMinLength(5);
        this.validator.setMaxLength(12);

        if (this.validator.isString()) {
            this.district = district;
            return true;
        }

        return false;
    }

    public String getContactNumber(){return contactNumber;}

    public boolean setContactNumber(String contactNumber){
        this.validator.setTxt(contactNumber);
        this.validator.setMinLength(10);
        this.validator.setMaxLength(10);

        if (this.validator.isNumber()) {
            this.contactNumber = contactNumber;
            return true;
        }

        return false;
    }
}
