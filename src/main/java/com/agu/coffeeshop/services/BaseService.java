package com.agu.coffeeshop.services;

import java.util.List;

public interface BaseService<T> {

    T findById(String id);

    List<T> findAll();

    T save(T entity);

    T update(T entity);

    void delete(T entity);
}
