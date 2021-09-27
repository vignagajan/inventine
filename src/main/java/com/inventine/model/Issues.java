package com.inventine.model;

import com.inventine.util.DataValidator;

public class Issues {

    private String issueId;
    private String description;
    private String category;
    private DataValidator validator = new DataValidator();


    public String getIssueId() {
        return issueId;
    }

    public String getCategory() {
        return category;
    }

    public boolean setCategory(String category) {
        this.validator.setTxt(category);
        this.validator.setMaxLength(1);
        this.validator.setMinLength(1);

        if (this.validator.isCapital()){
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

    public boolean setDescription(String description) {
        this.validator.setTxt(description);
        this.validator.setMaxLength(500);
        if(this.validator.isAlphaNumeric()){
            this.description = description;
            return true;
        }
        return false;
    }
}
