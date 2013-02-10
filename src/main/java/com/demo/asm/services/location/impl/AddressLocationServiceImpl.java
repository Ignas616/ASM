package com.demo.asm.services.location.impl;


import com.demo.asm.model.location.AddressLocation;
import com.demo.asm.repository.asm.location.AddressLocationRepository;
import com.demo.asm.services.location.AddressLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("addressLocationService")
public class AddressLocationServiceImpl implements AddressLocationService {

    @Autowired
    private AddressLocationRepository repository;

    @Override
    public AddressLocation getById(int id) {
        return repository.get(AddressLocation.class, id);
    }

    @Override
    public List<AddressLocation> getAll() {
        return repository.getAll(AddressLocation.class);
    }

    @Override
    public void save(AddressLocation toSave) {
        repository.save(toSave);
    }

    @Override
    public void delete(AddressLocation toDelete) {
        repository.delete(toDelete);
    }

}
