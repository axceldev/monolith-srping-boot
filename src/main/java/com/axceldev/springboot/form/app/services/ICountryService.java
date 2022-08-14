package com.axceldev.springboot.form.app.services;

import java.util.List;

import com.axceldev.springboot.form.app.models.domain.Country;

public interface ICountryService {
    
    public List<Country> getListAllCountry();

    public Country getCountryById( Integer idCountry );

}
