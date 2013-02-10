package com.demo.asm.repository.asm.device;

import com.demo.asm.model.device.DeviceType;
import com.demo.asm.model.shelf.Shelf;
import com.demo.asm.repository.BaseRepository;

import java.util.List;

/**
 * Repository for implementing any database method and functions
 * related with Device Entity.
 * Connects Entity models and services.
 * @author Ignas Nikolaejv
 */
public interface DeviceRepository extends BaseRepository {

    /**
     *
      * @return  list of all possible device types
     */
    public List<DeviceType> getAllDeviceTypes();

    /**
     *
     * @param deviceTypeId
     * @return list of all shelf objects for that device type id
     */
    public List<Shelf> getAllShelvesForThisDeviceType(int deviceTypeId);

    /**
     *
     * @param id deviceType Id
     * @return deviceType
     */
    public DeviceType loadDeviceTypeById(int id);

}
