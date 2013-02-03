package com.demo.asm.repository.asm.device;

import com.demo.asm.model.device.DeviceType;
import com.demo.asm.model.shelf.Shelf;
import com.demo.asm.repository.BaseRepository;

import java.util.List;

public interface DeviceRepository extends BaseRepository {

   public List<DeviceType> getAllDeviceTypes();

   public List<Shelf> getAllShelvesForThisDeviceType(int deviceTypeId);

   public DeviceType loadDeviceTypeById(int id);

}
