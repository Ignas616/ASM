package com.demo.asm.services.location;

import com.demo.asm.model.location.AddressLocation;

import java.util.List;

public interface AddressLocationService {

    public AddressLocation getById(int id);

    public List<AddressLocation> getAll();

    public void save(AddressLocation toSave);

    public void delete(AddressLocation toDelete);

}
