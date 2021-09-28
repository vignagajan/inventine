package com.inventine.model;

import com.inventine.util.DataValidator;

public class Issues {

    private String issueId;
    private String description;
    private char category;
    private DataValidator validator = new DataValidator();


    public String getIssueId() {
        return issueId;
    }

    public char getCategory() {
        return category;
    }

    public boolean setCategory(char category) {

        if (category == 'P' || category == 'C' || category == 'R'){
            this.category = category;
            return true;
        }


        return false;
    }

    public Boolean setIssueId(String issueId) {
        this.validator.setTxt(issueId);
        if (this.validator.isNumber()){
            this.issueId = issueId;
            return true;
        }
        return false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.validator.setTxt(description);
        this.validator.setMaxLength(500);
        this.description = description;
    }
}
