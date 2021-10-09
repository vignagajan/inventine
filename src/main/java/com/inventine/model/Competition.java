package com.inventine.model;

import com.inventine.util.DataValidator;
import java.sql.Timestamp;

public class Competition {
    private String competitionId;
    private String organizationId;
    private String projectId;
    private String supportTeamId;
    private Timestamp createdAt;
    private Timestamp endingAt;
    private int prizeMoney;
    private String type;
    private String rules;
    private DataValidator validator = new DataValidator();

    public String getCompetitionId(){ return competitionId;}

    public boolean setCompetitionId(String competitionId) {
        this.validator.setTxt(competitionId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.competitionId = competitionId;
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

    public Timestamp getEndingAt(){ return endingAt;}

    public boolean setEndingAt(Timestamp endingAt){
        try{
            this.endingAt = endingAt;

        }catch (Exception e){
            return true;
        }

        return false;
    }

    public int getPrizeMoney() {return prizeMoney;}

    public boolean setPrizeMoney(int prizeMoney) {

        if (prizeMoney >= 0) {
            this.prizeMoney = prizeMoney;
            return true;
        }
        return false;
    }

    public String getType(){return type;}

    public boolean setType(String type){
        this.validator.setMinLength(1);

        if (this.validator.isAlphaNumeric()) {
            this.type = type;
            return true;
        }

        return false;
    }

    public String getRules(){return rules;}

    public boolean setRules(String rules){
        this.validator.setMinLength(1);

        if (this.validator.isAlphaNumeric()) {
            this.rules = rules;
            return true;
        }

        return false;
    }

    public String getSupportTeamId() {
        return supportTeamId;
    }

    public boolean setSupportTeamId(String supportTeamId) {
        this.validator.setTxt(supportTeamId);
        this.validator.setMaxLength(6);
        this.validator.setMinLength(2);
        if(this.validator.isNumber())
        {
            this.supportTeamId = supportTeamId;
            return true;
        }

         return false;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public boolean setOrganizationId(String organizationId) {
        this.validator.setTxt(organizationId);
        this.validator.setMaxLength(6);
        this.validator.setMinLength(2);
        if(this.validator.isNumber())
        {
            this.organizationId = organizationId;
            return true;
        }
        return false;

    }

    public String getProjectId() {
        return projectId;
    }

    public boolean setProjectId(String projectId) {
        this.validator.setTxt(projectId);
        this.validator.setMaxLength(6);
        this.validator.setMinLength(2);
        if(this.validator.isNumber())
        {
            this.projectId = projectId;
            return true;
        }
         return false;
    }
}

/*
 public boolean setCategory(char category) {

        if (category == 'P' || category == 'C' || category == 'R'){
            this.category = category;
            return true;
        }
 */