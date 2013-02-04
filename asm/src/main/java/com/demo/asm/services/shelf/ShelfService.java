package com.demo.asm.services.shelf;

import com.demo.asm.model.card.Card;
import com.demo.asm.model.shelf.Shelf;
import com.demo.asm.model.shelf.ShelfType;

import java.util.List;

public interface ShelfService {
	
		public Shelf getById(int id);
		public List<Shelf> getAll();
        public List<Card> getAllCardsForThisShelfType(int shelfTypeId);
        public List<Card> getAllCardsForThisShelfId(int shelfId);
        public List<ShelfType> getAllShelfTypes();
		public void save(Shelf toSave);
        public void delete(Shelf toDelete);

}
