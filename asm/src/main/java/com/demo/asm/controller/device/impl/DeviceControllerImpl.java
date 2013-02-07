package com.demo.asm.controller.device.impl;

import com.demo.asm.controller.device.DeviceController;
import com.demo.asm.model.device.Device;
import com.demo.asm.model.device.DeviceType;
import com.demo.asm.model.location.AddressLocation;
import com.demo.asm.model.location.PhysicalLocation;
import com.demo.asm.model.shelf.Shelf;
import com.demo.asm.services.device.DeviceService;
import com.demo.asm.services.location.AddressLocationService;
import com.demo.asm.services.location.PhysicalLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@Controller("deviceController")
@Scope("session")
public class DeviceControllerImpl implements DeviceController {

    @Autowired
    private DeviceService service;

    @Autowired
    private PhysicalLocationService physicalService;

    @Autowired
    private AddressLocationService addressService;

    private List<Device> deviceList;

    private List<DeviceType> deviceTypeList;

    private Device selected;

    private List<Shelf> shelfList;

    private Shelf selectedShelf;

    private List<PhysicalLocation> physicalLocationList;

    private PhysicalLocation selectedPhysicalLocation;

    private List<AddressLocation> addressLocationList;

    private AddressLocation selectedAddressLocation;


    public DeviceService getService() {
        return service;
    }

    public void setService(DeviceService service) {
        this.service = service;
    }

    public PhysicalLocationService getPhysicalService() {
        return physicalService;
    }

    public void setPhysicalService(PhysicalLocationService physicalService) {
        this.physicalService = physicalService;
    }

    public AddressLocationService getAddressService() {
        return addressService;
    }

    public void setAddressService(AddressLocationService addressService) {
        this.addressService = addressService;
    }

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public List<DeviceType> getDeviceTypeList() {
        return deviceTypeList;
    }

    public void setDeviceTypeList(List<DeviceType> deviceTypeList) {
        this.deviceTypeList = deviceTypeList;
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

    public List<PhysicalLocation> getPhysicalLocationList() {
        return physicalLocationList;
    }

    public void setPhysicalLocationList(List<PhysicalLocation> physicalLocationList) {
        this.physicalLocationList = physicalLocationList;
    }

    public PhysicalLocation getSelectedPhysicalLocation() {
        return selectedPhysicalLocation;
    }

    public void setSelectedPhysicalLocation(PhysicalLocation selectedPhysicalLocation) {
        this.selectedPhysicalLocation = selectedPhysicalLocation;
    }

    public List<AddressLocation> getAddressLocationList() {
        return addressLocationList;
    }

    public void setAddressLocationList(List<AddressLocation> addressLocationList) {
        this.addressLocationList = addressLocationList;
    }

    public AddressLocation getSelectedAddressLocation() {
        return selectedAddressLocation;
    }

    public void setSelectedAddressLocation(AddressLocation selectedAddressLocation) {
        this.selectedAddressLocation = selectedAddressLocation;
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
        if (selected.getDeviceType().getNoOfShelves() > selected.getShelfList().size()) {
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

    public void getPhysicalLocations() {
        setPhysicalLocationList(physicalService.getAll());
    }

    public void getAddressLocations() {
        setAddressLocationList(addressService.getAll());
    }

    public void addSelectedLocation() {
        selected.setAddessLocation(getSelectedAddressLocation());
        selected.setPhysicalLocation(getSelectedPhysicalLocation());
        setSelectedAddressLocation(null);
        setSelectedPhysicalLocation(null);
    }

    public boolean validateBeforeSave() {
        for(Shelf shelf: selected.getShelfList()){
            if (shelf.getDevice() != null && shelf.getDevice().getId() != selected.getId()){
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "This shelf is already in use: "+ shelf.getNumber()+" on the device: "+shelf.getDevice().getName());
                FacesContext.getCurrentInstance().addMessage("adminSaveMsg", msg);
                return false;
            }
        }

        if (selected.getShelfList() != null && selected.getShelfList().size() > 0) {
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
