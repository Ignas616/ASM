package com.demo.asm.controller.shelf.impl;

import com.demo.asm.controller.shelf.ShelfController;
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
	
	private List<Shelf> ShelfList;

    private List<ShelfType> ShelfTypeList;
	
	private Shelf selected;

    public List<ShelfType> getShelfTypeList() {
        return ShelfTypeList;
    }

    public void setShelfTypeList(List<ShelfType> ShelfTypeList) {
        this.ShelfTypeList = ShelfTypeList;
    }

    public ShelfService getService() {
		return service;
	}

	public void setService(ShelfService service) {
		this.service = service;
	}
	
	public List<Shelf> getShelfList() {
		return ShelfList;
	}

	public void setShelfList(List<Shelf> ShelfList) {
		this.ShelfList = ShelfList;
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
	
	public boolean checkSelected() {
        return getSelected() != null;
	}

}
