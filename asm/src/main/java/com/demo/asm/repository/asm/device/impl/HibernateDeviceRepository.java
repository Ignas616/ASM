package com.demo.asm.repository.asm.device.impl;

import com.demo.asm.model.device.DeviceType;
import com.demo.asm.repository.asm.device.DeviceRepository;
import org.springframework.stereotype.Repository;

import com.demo.asm.repository.impl.HibernateBaseRepository;

import java.util.List;

@Repository
public class HibernateDeviceRepository extends HibernateBaseRepository implements DeviceRepository {

    @Override
    public List<DeviceType> getAllDeviceTypes() {
        return getHibernateTemplate().loadAll(DeviceType.class);
    }

    @Override
    public DeviceType loadDeviceTypeById(int id) {
        return getHibernateTemplate().get(DeviceType.class, id);
    }
}
