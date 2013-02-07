package com.demo.asm.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Base data access object
 */
public interface BaseRepository {
    /**
     * Stores given entity to database
     *
     * @param entity
     */
    void save(Object entity);

    /**
     * Stores collection of entities to database
     *
     * @param entities
     */
    void saveAll(Collection<?> entities);


    /**
     * Removes given entity from database
     *
     * @param entity
     */
    void delete(Object entity);

    /**
     * Removed collection of entities from database
     *
     * @param entities
     */
    void deleteAll(Collection<?> entities);

    /**
     * Load entity from database by it's ID
     *
     * @param clazz Class of an entity object
     * @param id
     * @return entity object or null if object is not found
     */
    <T> T get(Class<T> clazz, Serializable id);

    /**
     * Load all data by class
     */
    <T> List<T> getAll(Class<T> clazz);

    public void merge(Object entity);
}