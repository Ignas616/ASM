package com.demo.asm.controller.shelf.impl;

import com.demo.asm.controller.shelf.ShelfController;
import com.demo.asm.model.card.Card;
import com.demo.asm.model.shelf.Shelf;
import com.demo.asm.model.shelf.ShelfType;
import com.demo.asm.services.shelf.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Controller("shelfController")
@Scope("session")
public class ShelfControllerImpl implements ShelfController {

	@Autowired
	private ShelfService service;
	
	private List<Shelf> shelfList;

    private List<ShelfType> shelfTypeList;
	
	private Shelf selected;

    private List<Card> cardList;

    private Card selectedCard;

    public ShelfControllerImpl() {
    }

    public ShelfService getService() {
		return service;
	}

	public void setService(ShelfService service) {
		this.service = service;
	}

    public List<Shelf> getShelfList() {
        return shelfList;
    }

    public void setShelfList(List<Shelf> shelfList) {
        this.shelfList = shelfList;
    }

    public List<ShelfType> getShelfTypeList() {
        return shelfTypeList;
    }

    public void setShelfTypeList(List<ShelfType> shelfTypeList) {
        this.shelfTypeList = shelfTypeList;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }

    public Shelf getSelected() {
		return selected;
	}

	public void setSelected(Shelf selected) {
		this.selected = selected;
	}

	@Override
	public void createNew() {
		Shelf tmpShelf = new Shelf();
		setSelected(tmpShelf);		
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
		setShelfList(service.getAll());
        setShelfTypeList(service.getAllShelfTypes());
	}

    public void check() {
        System.out.println(selected.getShelfType().getId());
    }

    public void updateCardList() {
        setCardList(service.getAllCardsForThisShelfType(selected.getShelfType().getId()));
    }

    public boolean addSelectedCard() {
        if(selected.getShelfType().getNoOfAllowedCardSlots()>selected.getCardList().size()){
            selected.getCardList().add(selectedCard);
            return true;
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Maximum Number Of Cards Reached");
            FacesContext.getCurrentInstance().addMessage("adminSaveMsg", msg);
            return false;
        }
    }

    public void removeCardUnit() {
        selected.getCardList().remove(selectedCard);
    }
	
	public boolean checkSelected() {
        return getSelected() != null;
	}

}
