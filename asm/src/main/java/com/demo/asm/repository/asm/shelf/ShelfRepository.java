package com.demo.asm.repository.asm.shelf;

import com.demo.asm.model.card.Card;
import com.demo.asm.model.shelf.ShelfType;
import com.demo.asm.repository.BaseRepository;

import java.util.List;

public interface ShelfRepository extends BaseRepository {

   public List<ShelfType> getAllShelfTypes();

   public List<Card> getAllCardsForThisShelfType(int shelfTypeId);

   public List<Card> getAllCardsForThisShelfId(int shelfId);

   public ShelfType loadShelfTypeById(int id);

}
