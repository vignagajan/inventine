package com.inventine.model;

import com.inventine.util.DataValidator;

import java.sql.Timestamp;

public class Post {

    private String postId;
    private String description;
    private Timestamp createdAt;
    private DataValidator validator = new DataValidator();

    public String getPostId() {
        return postId;
    }

    public boolean setPostId(String postId) {
        this.validator.setTxt(postId);
        if(this.validator.isNumber()){
            this.postId = postId;
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
        this.validator.setMinLength(2);
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public boolean setCreatedAt(Timestamp createdAt) {
        try{
            this.createdAt = createdAt;
            return true;
        }catch(Exception e )
        {
            return false;
        }
    }
}
