package com.axceldev.springboot.form.app.services;

import java.util.List;

import com.axceldev.springboot.form.app.models.domain.Role;

public interface IRoleService {
    
    public List<Role> getListAllRoles();

    public Role getRoleById( Integer idRole );
}
