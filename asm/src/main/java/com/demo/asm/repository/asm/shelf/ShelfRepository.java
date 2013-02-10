package com.demo.asm.repository.asm.shelf;

import com.demo.asm.model.card.Card;
import com.demo.asm.model.shelf.ShelfType;
import com.demo.asm.repository.BaseRepository;

import java.util.List;

/**
 * Repository for implementing any database method and functions
 * related with Shelf Entity.
 * Connects Entity models and services.
 * @author Ignas Nikolaejv
 */
public interface ShelfRepository extends BaseRepository {

    /**
     *
     * @return list of all possible shelf types
     */
    public List<ShelfType> getAllShelfTypes();

    /**
     *
     * @param shelfTypeId
     * @return list of all Card objects for that shelf type id
     */
    public List<Card> getAllCardsForThisShelfType(int shelfTypeId);

    /**
     *
     * @param shelfId
     * @return list of all Card objects that are connected with that shelf id
     */
    public List<Card> getAllCardsForThisShelfId(int shelfId);

    /**
     *
     * @param id ShelfType ID
     * @return returns Shelf Type
     */
    public ShelfType loadShelfTypeById(int id);

}
