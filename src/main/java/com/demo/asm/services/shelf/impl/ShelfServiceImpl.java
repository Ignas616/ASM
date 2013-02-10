package com.demo.asm.services.shelf.impl;

import com.demo.asm.model.card.Card;
import com.demo.asm.model.shelf.Shelf;
import com.demo.asm.model.shelf.ShelfType;
import com.demo.asm.repository.asm.shelf.ShelfRepository;
import com.demo.asm.services.shelf.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shelfService")
public class ShelfServiceImpl implements ShelfService {

    @Autowired
    private ShelfRepository repository;

    @Override
    public Shelf getById(int id) {
        return repository.get(Shelf.class, id);
    }

    @Override
    public List<Shelf> getAll() {
        return repository.getAll(Shelf.class);
    }

    @Override
    public List<Card> getAllCardsForThisShelfType(int shelfTypeId) {
        return repository.getAllCardsForThisShelfType(shelfTypeId);
    }

    @Override
    public List<Card> getAllCardsForThisShelfId(int shelfId) {
        return repository.getAllCardsForThisShelfId(shelfId);
    }

    @Override
    public List<ShelfType> getAllShelfTypes() {
        return repository.getAllShelfTypes();
    }

    @Override
    public void save(Shelf toSave) {
        repository.save(toSave);
    }

    @Override
    public void delete(Shelf toDelete) {
        repository.delete(toDelete);
    }

}
