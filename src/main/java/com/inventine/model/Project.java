package com.inventine.model;

import com.inventine.util.DataValidator;


import java.sql.Timestamp;

public class Project {
    private String projectId;
    private Timestamp createdAt;
    private String financialStatus;
    private String status;
    private int requestedAmount;
    private Timestamp dateOfExpiry;
    private DataValidator validator = new DataValidator();

    public String getProjectId(){ return projectId;}

    public boolean setProjectId(String projectId) {
        this.validator.setTxt(projectId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.projectId = projectId;
            return true;
        }

        return false;
    }

    public Timestamp getCreatedAt(){ return createdAt;}

    public boolean setCreatedAt(Timestamp createdAt){
        try{
            this.createdAt = createdAt;

        }catch (Exception e){
            return true;
        }

        return false;
    }

    public String getFinancialStatus(){ return financialStatus;}

    public boolean setFinancialStatus(String financialStatus){
        this.validator.setTxt(financialStatus);
        this.validator.setMaxLength(1);

        if (this.validator.isCapital()) {
            this.financialStatus = financialStatus;
            return true;
        }

        return false;
    }

    public String getStatus(){ return status;}

    public boolean setStatus(String status){
        this.validator.setTxt(status);
        this.validator.setMaxLength(1);

        if (this.validator.isCapital()) {
            this.status = status;
            return true;
        }

        return false;
    }

    public int getRequestedAmount() {return requestedAmount;}

    public boolean setRequestedAmount(int requestedAmount) {

        if (requestedAmount >= 0) {
            this.requestedAmount = requestedAmount;
            return true;
        }
        return false;
    }

    public Timestamp getDateOfExpiry(){ return dateOfExpiry;}

    public boolean setDateOfExpiry(Timestamp dateOfExpiry){
        try{
            this.dateOfExpiry = dateOfExpiry;

        }catch (Exception e){
            return true;
        }

        return false;
    }
}







