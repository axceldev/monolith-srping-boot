package com.axceldev.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

public class CapitalizedNamePropertyEditor extends PropertyEditorSupport{

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue( text.toUpperCase().trim() );
    }
    
}
