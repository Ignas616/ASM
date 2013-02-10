package com.demo.asm.services.location.impl;


import com.demo.asm.model.location.PhysicalLocation;
import com.demo.asm.repository.asm.location.PhysicalLocationRepository;
import com.demo.asm.services.location.PhysicalLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("physicalLocationService")
public class PhysicalLocationServiceImpl implements PhysicalLocationService {

    @Autowired
    private PhysicalLocationRepository repository;

    @Override
    public PhysicalLocation getById(int id) {
        return repository.get(PhysicalLocation.class, id);
    }

    @Override
    public List<PhysicalLocation> getAll() {
        return repository.getAll(PhysicalLocation.class);
    }

    @Override
    public void save(PhysicalLocation toSave) {
        repository.save(toSave);
    }

    @Override
    public void delete(PhysicalLocation toDelete) {
        repository.delete(toDelete);
    }

}
