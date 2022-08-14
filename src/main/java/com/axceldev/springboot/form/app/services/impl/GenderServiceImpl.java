package com.axceldev.springboot.form.app.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.axceldev.springboot.form.app.models.domain.Gender;
import com.axceldev.springboot.form.app.services.IGenderService;

@Service
public class GenderServiceImpl  implements IGenderService{

    private List<Gender> genderList;

    public GenderServiceImpl() {
        this.genderList = Arrays.asList(
            new Gender(1, "Hombre"),
            new Gender(2, "Mujer"), 
            new Gender(3, "Indefinido")); 
    }

    @Override
    public Gender getGenderById( Integer idGender ) {
        return this.genderList.stream()
        .filter( gender -> gender.getIdGender().equals( idGender ))
        .collect( Collectors.toList() )
        .get(0);
    }

    @Override
    public List<Gender> getListAllGender() {
        return this.genderList;
    }
    
}
