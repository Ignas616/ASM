package com.demo.asm.services.location;

import com.demo.asm.model.location.PhysicalLocation;

import java.util.List;

/**
 * Service for executing any Shelf related business logic
 * Serves as connection between repository and controller
 * @author Ignas Nikolajev
 */
public interface PhysicalLocationService {

    /**
     * Sends request to repository to fetch the object with that Id
     * @param id
     * @return
     */
    public PhysicalLocation getById(int id);

    /**
     * Sends request to repository to fetch all object of this class from database
     * @return list of physical location objects
     */
    public List<PhysicalLocation> getAll();

    /**
     * Sends request to repository to save that object in database
     * @param toSave
     */
    public void save(PhysicalLocation toSave);

    /**
     * Sends request to repository to delete that object in database
     * @param toDelete
     */
    public void delete(PhysicalLocation toDelete);

}
