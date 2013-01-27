package com.demo.asm.services.device;

import java.util.List;

import com.demo.asm.model.device.Device;

public interface DeviceService {
	
		public Device getById(int id);
		public List<Device> getAll();
		public void save(Device toSave);

}
