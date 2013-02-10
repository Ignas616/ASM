package com.demo.asm.controller.card.impl;

import com.demo.asm.controller.card.CardController;
import com.demo.asm.model.card.Card;
import com.demo.asm.model.card.CardType;
import com.demo.asm.services.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Controller("cardController")
@Scope("session")
public class CardControllerImpl implements CardController {

    @Autowired
    private CardService service;

    private List<Card> cardList;

    private List<CardType> cardTypeList;

    private Card selected;

    public List<CardType> getCardTypeList() {
        return cardTypeList;
    }

    public void setCardTypeList(List<CardType> cardTypeList) {
        this.cardTypeList = cardTypeList;
    }

    public CardService getService() {
        return service;
    }

    public void setService(CardService service) {
        this.service = service;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public Card getSelected() {
        return selected;
    }

    public void setSelected(Card selected) {
        this.selected = selected;
    }

    @Override
    public void createNew() {
        Card tmpCard = new Card();
        setSelected(tmpCard);
    }

    @Override
    public void save() {
        try {
            service.save(getSelected());
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved", "Data Saved");
            FacesContext.getCurrentInstance().addMessage("adminSaveMsg", msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error during saving! " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage("adminSaveMsg", msg);
        }
    }

    @Override
    public void delete() {
        try {
            service.delete(getSelected());
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleted", "Data Removed");
            FacesContext.getCurrentInstance().addMessage("adminSaveMsg", msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error during delete! " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage("adminSaveMsg", msg);
        }
    }

    public void updateData() {
        setCardList(service.getAll());
        setCardTypeList(service.getAllCardTypes());
    }

    public boolean checkSelected() {
        return getSelected() != null;
    }

}
