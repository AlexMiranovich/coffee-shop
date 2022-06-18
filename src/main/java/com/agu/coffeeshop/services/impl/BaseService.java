package com.agu.coffeeshop.services.impl;

import com.agu.coffeeshop.entities.Changeable;
import com.agu.coffeeshop.entities.History;
import com.agu.coffeeshop.entities.Identifiable;
import com.agu.coffeeshop.repositories.impl.BaseRepository;
import com.agu.coffeeshop.services.HistoryService;

import java.util.List;

public abstract class BaseService<T extends Identifiable & Changeable<T>> {

    protected BaseRepository<T> baseRepository;
    private final HistoryService historyService;

    public BaseService(BaseRepository<T> baseRepository, HistoryService historyService) {
        this.baseRepository = baseRepository;
        this.historyService = historyService;
    }

    public T findById(String id) { return baseRepository.findById(id); }

    public List<T> findAll() { return baseRepository.findAll(); }

    public T save(T entity) {
        T createdEntity = baseRepository.save(entity);
        historyService.save(createdEntity.getId(), History.HistoryAction.COMPOSE, null);
        return createdEntity;
    }

    public T update(T entity) {
        T oldEntity = baseRepository.findById(entity.getId());
        T newEntity = baseRepository.update(entity);

        List<History.Change> changes = oldEntity.getChanges(newEntity);
        if (!changes.isEmpty())
            historyService.save(oldEntity.getId(), History.HistoryAction.UPDATE, changes);

        return newEntity;
    }

    public void delete(T entity) { baseRepository.delete(entity); }
}
