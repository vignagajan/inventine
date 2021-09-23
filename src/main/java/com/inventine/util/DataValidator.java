package com.inventine.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    private String txt;
    private int minLength = 1;
    private int maxLength = 100;

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public boolean isMatch(String PATTERN){
        PATTERN = String.format("^[%s]{%d,%d}$",PATTERN,this.minLength,this.maxLength);
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher match = pattern.matcher(this.txt);
        return match.matches();
    }

    public boolean isSmall(){

        return isMatch("a-z");
    }

    public boolean isCapital(){

        return isMatch("A-Z");
    }

    public boolean isString(){

        return isMatch("a-zA-Z");
    }

    public boolean isNumber(){

        return isMatch("0-9");
    }

}