package com.inventine.model;

import com.inventine.util.DataValidator;

public class University extends Organization{
    private String email;
    private DataValidator validator = new DataValidator();

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        this.validator.setTxt(email);
        this.validator.setMaxLength(50);
        this.validator.setMinLength(6);

        if(this.validator.isEmail()){
            this.email = email;
            return true;

        }

        return false;
    }
}
