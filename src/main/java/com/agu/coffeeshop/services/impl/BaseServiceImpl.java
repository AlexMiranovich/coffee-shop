package com.agu.coffeeshop.services.impl;

import com.agu.coffeeshop.repositories.BaseRepository;
import com.agu.coffeeshop.services.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BaseServiceImpl<T> implements BaseService<T> {

    private final BaseRepository<T> baseRepository;

    @Override
    public T findById(String id) { return baseRepository.findById(id); }

    @Override
    public List<T> findAll() { return baseRepository.findAll(); }

    @Override
    public T save(T entity) { return baseRepository.save(entity); }

    @Override
    public T update(T entity) { return baseRepository.update(entity); }

    @Override
    public void delete(T entity) { baseRepository.delete(entity); }
}
