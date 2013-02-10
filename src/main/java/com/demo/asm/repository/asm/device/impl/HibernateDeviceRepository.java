package com.demo.asm.repository.asm.device.impl;

import com.demo.asm.model.device.DeviceAllowedCardType;
import com.demo.asm.model.device.DeviceType;
import com.demo.asm.model.shelf.Shelf;
import com.demo.asm.repository.asm.device.DeviceRepository;
import com.demo.asm.repository.impl.HibernateBaseRepository;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateDeviceRepository extends HibernateBaseRepository implements DeviceRepository {

    @Override
    public List<DeviceType> getAllDeviceTypes() {
        return getHibernateTemplate().loadAll(DeviceType.class);
    }


    @Override
    public List<Shelf> getAllShelvesForThisDeviceType(int deviceTypeId) {

        DetachedCriteria criteria = DetachedCriteria.forClass(Shelf.class);
        DetachedCriteria subCriteria = DetachedCriteria.forClass(DeviceAllowedCardType.class);

        subCriteria.setProjection(Projections.property("shelfTypeId"));
        subCriteria.add(Restrictions.eq("deviceTypeId", deviceTypeId));

        criteria.add(Subqueries.propertyIn("shelfType.id", subCriteria));

        List<Shelf> tmpList = getHibernateTemplate().findByCriteria(criteria);
        if (tmpList != null && tmpList.size() > 0) {
            return tmpList;
        } else {
            return null;
        }
    }


    @Override
    public DeviceType loadDeviceTypeById(int id) {
        return getHibernateTemplate().get(DeviceType.class, id);
    }
}
