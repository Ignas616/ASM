package com.demo.asm.services.card.impl;

import com.demo.asm.model.card.Card;
import com.demo.asm.model.card.CardType;
import com.demo.asm.model.report.CardTypeReport;
import com.demo.asm.repository.asm.card.CardRepository;
import com.demo.asm.services.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cardService")
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository repository;

    @Override
    public Card getById(int id) {
        return repository.get(Card.class, id);
    }

    @Override
    public List<Card> getAll() {
        return repository.getAll(Card.class);
    }

    @Override
    public List<CardType> getAllCardTypes() {
        return repository.getAllCardTypes();
    }

    @Override
    public List<CardTypeReport> getCardTypeReport(int cardTypeId) {
        return repository.getCardTypeReport(cardTypeId);
    }

    @Override
    public void save(Card toSave) {
        repository.save(toSave);
    }

    @Override
    public void delete(Card toDelete) {
        repository.delete(toDelete);
    }

}
