package com.demo.asm.repository.asm.card;

import com.demo.asm.model.card.CardType;
import com.demo.asm.model.report.CardTypeReport;
import com.demo.asm.repository.BaseRepository;

import java.util.List;

/**
 * Repository for implementing any database method and functions
 * related with Card Entity.
 * Connects Entity models and services.
 * @author Ignas Nikolaejv
 */
public interface CardRepository extends BaseRepository {

    /**
     *
      * @return  list of all possible card types
     */
    public List<CardType> getAllCardTypes();

    /**
     *
     * @param id  Card Type ID
     * @return card Type
     */
    public CardType loadCardTypeById(int id);

    /**
     * Returns List of custom report type objects that are fethced from db function by given card type Id
     * The fetching is done by special db function - get_card_type_report(int cardTypeId)
     *
     * @param cardTypeId
     * @return List of CardTypeReport objects
     */
    public List<CardTypeReport> getCardTypeReport(int cardTypeId);

}
