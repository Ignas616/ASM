package com.demo.asm.repository.asm.card.impl;

import com.demo.asm.model.card.CardType;
import com.demo.asm.repository.asm.card.CardRepository;
import com.demo.asm.repository.impl.HibernateBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateCardRepository extends HibernateBaseRepository implements CardRepository {

    @Override
    public List<CardType> getAllCardTypes() {
        return getHibernateTemplate().loadAll(CardType.class);
    }

    @Override
    public CardType loadCardTypeById(int id) {
        return getHibernateTemplate().get(CardType.class, id);
    }
}
