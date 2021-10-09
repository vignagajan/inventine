package com.inventine.model;

import com.inventine.util.DataValidator;

public class Organization {
    private String organizationId;
    private String creatorId;
    private String SupportTeamId;
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

    public String getSupportTeamId() {
        return SupportTeamId;
    }

    public boolean setSupportTeamId(String supportTeamId) {
        this.validator.setTxt(supportTeamId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            SupportTeamId = supportTeamId;
            return true;
        }
        return false;
    }
    public String getName(){return name;}

    public boolean setName(String name){
        this.validator.setTxt(name);
        this.validator.setMaxLength(50);
        this.validator.setMinLength(3);

        if (this.validator.isAlphaNumeric()) {
            this.name = name;
            return true;
        }

        return false;
    }

    public String getAddress(){return address;}

    public boolean setAddress(String address){
        this.validator.setTxt(address);


        if (this.validator.isAddress()) {
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



        if (this.validator.isPhone()) {
            this.contactNumber = contactNumber;
            return true;
        }

        return false;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public boolean setCreatorId(String creatorId) {
        this.validator.setTxt(creatorId);
        this.validator.setMaxLength(6);

        if(this.validator.isNumber())
        {
            this.creatorId = creatorId;
            return true;
        }
         return false;

    }
}
