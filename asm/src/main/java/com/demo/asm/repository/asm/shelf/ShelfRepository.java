package com.demo.asm.repository.asm.shelf;

import com.demo.asm.model.shelf.ShelfType;
import com.demo.asm.repository.BaseRepository;

import java.util.List;

public interface ShelfRepository extends BaseRepository {

   public List<ShelfType> getAllShelfTypes();

   public ShelfType loadShelfTypeById(int id);

}
