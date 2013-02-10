package com.demo.asm.services.device;

import com.demo.asm.model.device.Device;
import com.demo.asm.model.device.DeviceType;
import com.demo.asm.model.shelf.Shelf;

import java.util.List;

/**
 * Service for executing any Shelf related business logic
 * Serves as connection between repository and controller
 * @author Ignas Nikolajev
 */
public interface DeviceService {

    /**
     * Sends request to repository to fetch the object with that Id
     * @param id
     * @return
     */
    public Device getById(int id);

    /**
     * Sends request to repository to fetch all object of this class from database
     * @return list of device objects
     */
    public List<Device> getAll();

    /**
     * Sends request to repository to fetch all object of this class from database
     * @return list of device type objects
     */
    public List<DeviceType> getAllDeviceTypes();


    /**
     * Sends request to repository to fetch all shelf object of this device type id from database
     * @param deviceTypeId
     * @return list of shelf objects
     */
    public List<Shelf> getAllShelvesForThisDeviceType(int deviceTypeId);

    /**
     * Sends request to repository to save that object in database
     * @param toSave
     */
    public void save(Device toSave);

    /**
     * Sends request to repository to delete that object in database
     * @param toDelete
     */
    public void delete(Device toDelete);

}
