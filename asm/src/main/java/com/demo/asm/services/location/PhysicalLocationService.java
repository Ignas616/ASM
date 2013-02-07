package com.demo.asm.services.location;

import com.demo.asm.model.location.PhysicalLocation;

import java.util.List;

public interface PhysicalLocationService {

    public PhysicalLocation getById(int id);

    public List<PhysicalLocation> getAll();

    public void save(PhysicalLocation toSave);

    public void delete(PhysicalLocation toDelete);

}
