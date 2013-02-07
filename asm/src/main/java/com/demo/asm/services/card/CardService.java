package com.demo.asm.services.card;

import com.demo.asm.model.card.Card;
import com.demo.asm.model.card.CardType;
import com.demo.asm.model.report.CardTypeReport;

import java.util.List;

public interface CardService {

    public Card getById(int id);

    public List<Card> getAll();

    public List<CardType> getAllCardTypes();

    public List<CardTypeReport> getCardTypeReport(int cardTypeId);

    public void save(Card toSave);

    public void delete(Card toDelete);

}
