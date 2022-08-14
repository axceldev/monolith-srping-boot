package com.axceldev.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.axceldev.springboot.form.app.services.IGenderService;

@Component
public class GenderPropertyEditor extends PropertyEditorSupport {

    @Autowired
    private IGenderService genderService;

    @Override
    public void setAsText( String idGender ) throws IllegalArgumentException {
        try {
            setValue( genderService.getGenderById( Integer.parseInt( idGender ) ) );
        } catch (NumberFormatException e) {
            setValue(null);
        }
    }
    
}
