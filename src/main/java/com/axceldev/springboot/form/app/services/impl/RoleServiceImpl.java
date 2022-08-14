package com.axceldev.springboot.form.app.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.axceldev.springboot.form.app.models.domain.Role;
import com.axceldev.springboot.form.app.services.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

    private List<Role> listRoles;

    public RoleServiceImpl() {
        
        this.listRoles = Arrays.asList( 
			new Role(1, "ROLE_ADMI", "Administrador"), 
			new Role(2, "ROLE_CONT", "Contador"), 
			new Role(3, "ROLE_AUDI",  "Auditor"), 
			new Role(4, "ROLE_COOR", "Coordinador"),
			new Role(5, "ROLE_LIDE", "Lider"),
			new Role(6, "ROLE_GERE", "Gerente"));
    }

    @Override
    public List<Role> getListAllRoles() {

        return this.listRoles;

    }

    @Override
    public Role getRoleById(Integer idRole) {

        return this.listRoles.stream()
        .filter( rol -> rol.getIdRole().equals( idRole ) )
        .collect( Collectors.toList() )
        .get(0);

    }
    
}
