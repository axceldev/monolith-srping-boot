package com.axceldev.springboot.form.app.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.axceldev.springboot.form.app.models.domain.Country;
import com.axceldev.springboot.form.app.services.ICountryService;

@Service
public class CountryServiceImpl implements ICountryService {

    private List<Country> countryList;

    public CountryServiceImpl() {
        this.countryList = Arrays.asList( 
			new Country(1, "CO", "Colombia"), 
			new Country(2, "ME", "Mexico"), 
			new Country(3, "CL", "Chile"), 
			new Country(4, "BR", "Brasil"),
			new Country(5, "EU", "Estados Unidos"),
			new Country(6, "ES", "España"));
    }

    @Override
    public Country getCountryById(Integer idCountry) {
        
        Country countryById = this.countryList.stream()
        .filter( country -> country.getIdCountry().equals( idCountry ))
        .collect( Collectors.toList())
        .get(0);

        return countryById;
    }

    @Override
    public List<Country> getListAllCountry() {
        return this.countryList;
    }
    
}
