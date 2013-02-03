package com.demo.asm.services.device.impl;

import java.util.List;

import com.demo.asm.model.device.DeviceType;
import com.demo.asm.model.shelf.Shelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.asm.model.device.Device;
import com.demo.asm.repository.asm.device.DeviceRepository;
import com.demo.asm.services.device.DeviceService;

@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceRepository repository;

	@Override
	public Device getById(int id) {
		return repository.get(Device.class, id);
	}

	@Override
	public List<Device> getAll() {
		return repository.getAll(Device.class);
	}

    @Override
    public List<DeviceType> getAllDeviceTypes() {
      return repository.getAllDeviceTypes();
    }

    @Override
    public List<Shelf> getAllShelvesForThisDeviceType(int deviceTypeId) {
        return repository.getAllShelvesForThisDeviceType(deviceTypeId);
    }

    @Override
	public void save(Device toSave) {
		repository.save(toSave);
	}

    @Override
    public void delete(Device toDelete) {
        repository.delete(toDelete);
    }

}
