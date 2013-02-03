package com.demo.asm.repository.asm.shelf.impl;

import com.demo.asm.model.card.Card;
import com.demo.asm.model.shelf.ShelfAllowedCardType;
import com.demo.asm.model.shelf.ShelfType;
import com.demo.asm.repository.asm.shelf.ShelfRepository;
import com.demo.asm.repository.impl.HibernateBaseRepository;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateShelfRepository extends HibernateBaseRepository implements ShelfRepository {

    @Override
    public List<ShelfType> getAllShelfTypes() {
        return getHibernateTemplate().loadAll(ShelfType.class);
    }

    @Override
    public List<Card> getAllCardsForThisShelfType(int shelfTypeId) {

        String critAlias = "cardType";

        DetachedCriteria criteria = DetachedCriteria.forClass(Card.class);
        DetachedCriteria subCriteria = DetachedCriteria.forClass(ShelfAllowedCardType.class);

        subCriteria.setProjection(Projections.property(critAlias+"Id"));
        subCriteria.add(Restrictions.eq("shelfTypeId", shelfTypeId));

        criteria.add(Subqueries.propertyIn(critAlias + ".id", subCriteria));

        List<Card> tmpList = getHibernateTemplate().findByCriteria(criteria);
        if (tmpList != null && tmpList.size() > 0) {
            return tmpList;
        } else {
            return null;
        }
    }

    @Override
    public ShelfType loadShelfTypeById(int id) {
        return getHibernateTemplate().get(ShelfType.class, id);
    }
}
