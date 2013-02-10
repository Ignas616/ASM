package com.demo.asm.services.location;

import com.demo.asm.model.location.AddressLocation;

import java.util.List;

/**
 * Service for executing any Shelf related business logic
 * Serves as connection between repository and controller
 * @author Ignas Nikolajev
 */
public interface AddressLocationService {

    /**
     * Sends request to repository to fetch the object with that Id
     * @param id
     * @return
     */
    public AddressLocation getById(int id);

    /**
     * Sends request to repository to fetch all object of this class from database
     * @return list of address location objects
     */
    public List<AddressLocation> getAll();

    /**
     * Sends request to repository to save that object in database
     * @param toSave
     */
    public void save(AddressLocation toSave);

    /**
     * Sends request to repository to delete that object in dataabse
     * @param toDelete
     */
    public void delete(AddressLocation toDelete);

}
