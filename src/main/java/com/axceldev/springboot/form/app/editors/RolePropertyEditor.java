package com.axceldev.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.axceldev.springboot.form.app.services.IRoleService;

@Component
public class RolePropertyEditor extends PropertyEditorSupport {
    
    @Autowired
    private IRoleService roleService;

    @Override
    public void setAsText(String idRole) throws IllegalArgumentException {
        try {
            setValue( roleService.getRoleById( Integer.parseInt( idRole ) ) );
        } catch (NumberFormatException e) {
            setValue(null);
        }
    }

        
}
