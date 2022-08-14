package com.axceldev.springboot.form.app.models.domain;

public class Country {
    
  
    private Integer idCountry;
    private String codeCountry;
    private String nameCountry;

    public Country() {

    }

    public Country(Integer idCountry, String codeCountry, String nameCountry) {
        this.idCountry = idCountry;
        this.codeCountry = codeCountry;
        this.nameCountry = nameCountry;
    }

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public String getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(String codeCountry) {
        this.codeCountry = codeCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }
    
    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    @Override
    public String toString() {
        return this.getIdCountry().toString();
    }

    
}
