package com.demo.asm.controller.device.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.demo.asm.model.device.DeviceType;
import com.demo.asm.model.shelf.Shelf;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.asm.controller.device.DeviceController;
import com.demo.asm.model.device.Device;
import com.demo.asm.services.device.DeviceService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("deviceController")
@Scope("session")
public class DeviceControllerImpl implements DeviceController {

	@Autowired
	private DeviceService service;
	
	private List<Device> deviceList;

    private List<DeviceType> deviceTypeList;
	
	private Device selected;

    private List<Shelf> shelfList;

    private Shelf selectedShelf;

    public List<DeviceType> getDeviceTypeList() {
        return deviceTypeList;
    }

    public void setDeviceTypeList(List<DeviceType> deviceTypeList) {
        this.deviceTypeList = deviceTypeList;
    }

    public DeviceService getService() {
		return service;
	}

	public void setService(DeviceService service) {
		this.service = service;
	}
	
	public List<Device> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<Device> deviceList) {
		this.deviceList = deviceList;
	}

	public Device getSelected() {
		return selected;
	}

	public void setSelected(Device selected) {
		this.selected = selected;
	}

    public List<Shelf> getShelfList() {
        return shelfList;
    }

    public void setShelfList(List<Shelf> shelfList) {
        this.shelfList = shelfList;
    }

    public Shelf getSelectedShelf() {
        return selectedShelf;
    }

    public void setSelectedShelf(Shelf selectedShelf) {
        this.selectedShelf = selectedShelf;
    }

    @Override
	public void createNew() {
		Device tmpDevice = new Device();
        tmpDevice.setShelfList(new ArrayList<Shelf>());
		setSelected(tmpDevice);		
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
		setDeviceList(service.getAll());
        setDeviceTypeList(service.getAllDeviceTypes());
	}

    public void updateShelfList() {
        setShelfList(service.getAllShelvesForThisDeviceType(selected.getDeviceType().getId()));
    }

    public boolean addSelectedShelf() {
        if(selected.getDeviceType().getNoOfShelves()>selected.getShelfList().size()){
            selected.getShelfList().add(selectedShelf);
            return true;
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Maximum Number Of Cards Reached");
            FacesContext.getCurrentInstance().addMessage("adminSaveMsg", msg);
            return false;
        }
    }

    public void removeShelfUnit() {
        selected.getShelfList().remove(selectedShelf);
    }

    public boolean validateBeforeSave() {
        if(selected.getShelfList() != null && selected.getShelfList().size()>0){
            return true;
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "The Device Must Have At Least 1 Shelf");
            FacesContext.getCurrentInstance().addMessage("adminSaveMsg", msg);
            return false;
        }
    }
	
	public boolean checkSelected() {
        return getSelected() != null;
	}

}
