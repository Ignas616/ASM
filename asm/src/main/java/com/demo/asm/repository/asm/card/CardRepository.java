package com.demo.asm.repository.asm.card;

import com.demo.asm.model.card.CardType;
import com.demo.asm.repository.BaseRepository;

import java.util.List;

public interface CardRepository extends BaseRepository {

   public List<CardType> getAllCardTypes();

   public CardType loadCardTypeById(int id);

}
