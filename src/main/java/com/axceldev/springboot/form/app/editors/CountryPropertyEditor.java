package com.axceldev.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.axceldev.springboot.form.app.services.ICountryService;

@Component
public class CountryPropertyEditor extends PropertyEditorSupport{

    @Autowired
    private ICountryService countryService;

    @Override
    public void setAsText( String idCountry ) throws IllegalArgumentException {
        try {
            setValue( countryService.getCountryById( Integer.parseInt( idCountry ) ) ); 
        } catch (NumberFormatException e) {
            setValue(null);
        }
    }
    
}
