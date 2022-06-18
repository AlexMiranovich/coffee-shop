package com.agu.coffeeshop.services;

import com.agu.coffeeshop.entities.History;

import java.util.List;

public interface HistoryService {

    List<History> findAllById(String id);

    void save(String parentId, History.HistoryAction action, List<History.Change> changes);
}
