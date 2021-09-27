package com.inventine.model;

import com.inventine.util.DataValidator;

import java.sql.Timestamp;

public class Chat {

    private String chatId;
    private String receiver;
    private String content;
    private Timestamp createdAt;
    private DataValidator validator = new DataValidator();

    public String getChatId() {
        return chatId;
    }

    public boolean setChatId(String chatId) {

        this.validator.setTxt(chatId);
        this.validator.setMaxLength(6);
        this.validator.setMinLength(1);

        if(this.validator.isNumber())
        {
            this.chatId = chatId;
            return true;
        }
        return false;

    }

    public String getReceiver() {
        return receiver;
    }

    public boolean setReceiver(String receiver) {

        this.validator.setTxt(receiver);
        this.validator.setMaxLength(50);
        this.validator.setMinLength(3);

        if(this.validator.isString())
        {
            this.receiver = receiver;
            return true;

        }
        return false;


    }

    public String getContent() {
        return content;
    }

    public boolean setContent(String content) {

        this.validator.setTxt(content);
        this.validator.setMaxLength(255);
        this.validator.setMinLength(1);

        if(this.validator.isAlphaNumeric())
        {
            this.content = content;
            return true;
        }
         return false;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public boolean setCreatedAt(Timestamp createdAt) {

        try{
        this.createdAt = createdAt;
        return true;
    } catch (Exception e) {
            return false;
        }

    }


}
