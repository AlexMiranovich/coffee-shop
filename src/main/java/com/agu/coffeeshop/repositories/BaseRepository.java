package com.agu.coffeeshop.repositories;

import java.util.List;

public interface BaseRepository<T> {

    T findById(String id);

    List<T> findAll();

    T save(T entity);

    T update(T entity);

    void delete(T entity);
}
