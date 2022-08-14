package com.axceldev.springboot.form.app.services;

import java.util.List;

import com.axceldev.springboot.form.app.models.domain.Gender;

public interface IGenderService {
    
    public List<Gender> getListAllGender();

    public Gender getGenderById( Integer idGender );

}
