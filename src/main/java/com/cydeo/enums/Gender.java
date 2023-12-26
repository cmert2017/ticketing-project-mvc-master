package com.cydeo.enums;
//in some companies this folder may be called as utils
public enum Gender {
    MALE("Male"), FEMALE("Female");

    private final String value;


    Gender(String value) {
        this.value=value;
    }

    public String getValue(){
        return value;
    }
}
