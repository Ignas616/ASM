package com.demo.asm.converters.card;


import com.demo.asm.model.card.CardType;
import com.demo.asm.repository.asm.card.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component("cardTypeConverter")
public class CardTypeConverter implements Converter {

    @Autowired
    private CardRepository repository;

    @Override
    public Object getAsObject(FacesContext context, UIComponent arg1, String value) {
        try {
            return repository.loadCardTypeById(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
        if (value instanceof CardType) {
            return String.valueOf(((CardType) value).getId());
        } else {
            return null;
        }
    }
}
