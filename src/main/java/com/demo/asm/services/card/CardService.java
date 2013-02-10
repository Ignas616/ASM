package com.demo.asm.services.card;

import com.demo.asm.model.card.Card;
import com.demo.asm.model.card.CardType;
import com.demo.asm.model.report.CardTypeReport;

import java.util.List;

/**
 * Service for executing any Card related business logic
 * Serves as connection between repository and controller
 * @author Ignas Nikolajev
 */
public interface CardService {

    /**
     * Sends request to repository to fetch the object with that Id
     * @param id
     * @return
     */
    public Card getById(int id);

    /**
     * Sends request to repository to fetch all object of this class from database
     * @return list of card objects
     */
    public List<Card> getAll();

    /**
     * Sends request to repository to fetch all object of this class from database
     * @return list of card type objects
     */
    public List<CardType> getAllCardTypes();

    /**
     * Sends request to repository to fetch all card type report of this card type id from database
     *
     * @param cardTypeId
     * @return list of card type report objects
     */
    public List<CardTypeReport> getCardTypeReport(int cardTypeId);

    /**
     * Sends request to repository to save that object in database
     * @param toSave
     */
    public void save(Card toSave);

    /**
     * Sends request to repository to delete that object in database
     * @param toDelete
     */
    public void delete(Card toDelete);

}
