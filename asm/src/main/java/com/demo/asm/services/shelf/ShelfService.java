package com.demo.asm.services.shelf;

import com.demo.asm.model.card.Card;
import com.demo.asm.model.shelf.Shelf;
import com.demo.asm.model.shelf.ShelfType;

import java.util.List;

/**
 * Service for executing any Shelf related business logic
 * Serves as connection between repository and controller
 * @author Ignas Nikolajev
 */
public interface ShelfService {

    /**
     * Sends request to repository to fetch the object with that Id
     * @param id
     * @return
     */
    public Shelf getById(int id);

    /**
     * Sends request to repository to fetch all object of this class from database
     * @return list of shelf objects
     */
    public List<Shelf> getAll();

    /**
     * Sends request to repository to fetch all object of this class from database
     * @return list of shelf type objects
     */
    public List<ShelfType> getAllShelfTypes();

    /**
     * Sends request to repository to fetch all card object of this shelf type id from database
     * @param shelfTypeId
     * @return list of card objects
     */
    public List<Card> getAllCardsForThisShelfType(int shelfTypeId);

    /**
     * Sends request to repository to fetch all card object of this shelf id from database
     * @param shelfId
     * @return list of card objects
     */
    public List<Card> getAllCardsForThisShelfId(int shelfId);

    /**
     * Sends request to repository to save that object in database
     * @param toSave
     */
    public void save(Shelf toSave);

    /**
     * Sends request to repository to delete that object in database
     * @param toDelete
     */
    public void delete(Shelf toDelete);

}
