package com.inventine.model;

import com.inventine.util.DataValidator;


public class PrivateOrganization extends Organization {
    private String regNo;
    private DataValidator validator = new DataValidator();

    public String getRegNo(){ return regNo;}

    public boolean setRegNo(String regNo) {
        this.validator.setTxt(regNo);
        this.validator.setMaxLength(10);

        if (this.validator.isNumber()) {
            this.regNo = regNo;
            return true;
        }

        return false;
    }

}
