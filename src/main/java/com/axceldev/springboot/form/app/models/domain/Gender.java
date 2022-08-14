package com.axceldev.springboot.form.app.models.domain;

public class Gender {

    private Integer idGender;
    private String nameGender;
    
    public Gender() {
    
    }

    public Gender(Integer idGender, String nameGender) {
        this.idGender = idGender;
        this.nameGender = nameGender;
    }

    public Integer getIdGender() {
        return idGender;
    }

    public void setIdGender(Integer idGender) {
        this.idGender = idGender;
    }

    public String getNameGender() {
        return nameGender;
    }
    
    public void setNameGender(String nameGender) {
        this.nameGender = nameGender;
    }
}
