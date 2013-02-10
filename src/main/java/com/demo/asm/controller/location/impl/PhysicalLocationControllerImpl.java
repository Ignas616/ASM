package com.demo.asm.controller.location.impl;

import com.demo.asm.controller.location.PhysicalLocationController;
import com.demo.asm.model.location.PhysicalLocation;
import com.demo.asm.services.location.PhysicalLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Controller("physicalLocationController")
@Scope("session")
public class PhysicalLocationControllerImpl implements PhysicalLocationController {

    @Autowired
    private PhysicalLocationService service;

    private List<PhysicalLocation> physicalLocationList;

    private PhysicalLocation selected;

    public PhysicalLocationService getService() {
        return service;
    }

    public void setService(PhysicalLocationService service) {
        this.service = service;
    }

    public List<PhysicalLocation> getPhysicalLocationList() {
        return physicalLocationList;
    }

    public void setPhysicalLocationList(List<PhysicalLocation> physicalLocationList) {
        this.physicalLocationList = physicalLocationList;
    }

    public PhysicalLocation getSelected() {
        return selected;
    }

    public void setSelected(PhysicalLocation selected) {
        this.selected = selected;
    }

    @Override
    public void createNew() {
        PhysicalLocation tmpPhysicalLocation = new PhysicalLocation();
        setSelected(tmpPhysicalLocation);
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
        setPhysicalLocationList(service.getAll());
    }

    public boolean checkSelected() {
        return getSelected() != null;
    }

}
