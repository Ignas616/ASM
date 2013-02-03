package com.demo.asm.controller.location.impl;

import com.demo.asm.controller.location.AddressLocationController;
import com.demo.asm.model.location.AddressLocation;
import com.demo.asm.services.location.AddressLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Controller("addressLocationController")
@Scope("session")
public class AddressLocationControllerImpl implements AddressLocationController {

	@Autowired
	private AddressLocationService service;
	
	private List<AddressLocation> addressLocationList;

	private AddressLocation selected;

    public AddressLocationService getService() {
		return service;
	}

	public void setService(AddressLocationService service) {
		this.service = service;
	}
	
	public List<AddressLocation> getAddressLocationList() {
		return addressLocationList;
	}

	public void setAddressLocationList(List<AddressLocation> addressLocationList) {
		this.addressLocationList = addressLocationList;
	}

	public AddressLocation getSelected() {
		return selected;
	}

	public void setSelected(AddressLocation selected) {
		this.selected = selected;
	}

	@Override
	public void createNew() {
		AddressLocation tmpAddressLocation = new AddressLocation();
		setSelected(tmpAddressLocation);		
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
		setAddressLocationList(service.getAll());
	}
	
	public boolean checkSelected() {
        return getSelected() != null;
	}

}
