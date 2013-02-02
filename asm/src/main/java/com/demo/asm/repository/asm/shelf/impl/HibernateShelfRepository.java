package com.demo.asm.repository.asm.shelf.impl;

import com.demo.asm.model.shelf.ShelfType;
import com.demo.asm.repository.asm.shelf.ShelfRepository;
import com.demo.asm.repository.impl.HibernateBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateShelfRepository extends HibernateBaseRepository implements ShelfRepository {

    @Override
    public List<ShelfType> getAllShelfTypes() {
        return getHibernateTemplate().loadAll(ShelfType.class);
    }

    @Override
    public ShelfType loadShelfTypeById(int id) {
        return getHibernateTemplate().get(ShelfType.class, id);
    }
}
