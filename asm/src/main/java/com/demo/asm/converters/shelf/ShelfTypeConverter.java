package com.demo.asm.converters.shelf;

import com.demo.asm.model.shelf.ShelfType;
import com.demo.asm.repository.asm.shelf.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component("shelfTypeConverter")
public class ShelfTypeConverter implements Converter {

    @Autowired
    private ShelfRepository repository;

    @Override
    public Object getAsObject(FacesContext context, UIComponent arg1, String value) {
        try {
            return repository.loadShelfTypeById(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
        if (value instanceof ShelfType) {
            return String.valueOf(((ShelfType)value).getId());
        } else {
            return null;
        }
    }
}
