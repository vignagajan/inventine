package com.inventine.model;

import com.inventine.util.DataValidator;


import java.sql.Timestamp;

public class Project {
    private String projectId;
    private String creatorId;
    private String supportTeamId;
    private Timestamp createdAt;
    private char financialStatus;
    private char status;
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

    public String getCreatorId(){ return creatorId;}

    public boolean setCreatorId(String creatorId) {
        this.validator.setTxt(creatorId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.creatorId = creatorId;
            return true;
        }

        return false;
    }

    public String getSupportTeamId(){ return supportTeamId;}

    public boolean setSupportTeamId(String supportTeamId) {
        this.validator.setTxt(supportTeamId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.supportTeamId = supportTeamId;
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

    public char getFinancialStatus(){ return financialStatus;}

    public boolean setFinancialStatus(char financialStatus){

        if (financialStatus == 'C' || financialStatus == 'I') {
            this.financialStatus = financialStatus;
            return true;
        }

        return false;
    }

    public char getStatus(){ return status;}

    public boolean setStatus(char status){

        if (status == 'A' || status == 'B' || status == 'D' || status == 'U') {
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







