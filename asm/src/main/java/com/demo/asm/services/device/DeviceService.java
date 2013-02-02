package com.demo.asm.services.device;

import java.util.List;

import com.demo.asm.model.device.Device;
import com.demo.asm.model.device.DeviceType;

public interface DeviceService {
	
		public Device getById(int id);
		public List<Device> getAll();
        public List<DeviceType> getAllDeviceTypes();
		public void save(Device toSave);
        public void delete(Device toDelete);

}