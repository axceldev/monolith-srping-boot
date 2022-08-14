package com.axceldev.springboot.form.app.models.domain;

public class Role {
    private Integer idRole;
    private String nameRole;
    private String codeRole;

    public Role() {
    
    }

    public Role(Integer idRole, String codeRole, String nameRole) {
        this.idRole = idRole;
        this.nameRole = nameRole;
        this.codeRole = codeRole;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public String getCodeRole() {
        return codeRole;
    }

    public void setCodeRole(String codeRole) {
        this.codeRole = codeRole;
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj)
            return true;

        if(!(obj instanceof Role))
            return false;

        Role role = (Role) obj;
        return this.idRole != null && this.idRole.equals(role.getIdRole());
    }
}
