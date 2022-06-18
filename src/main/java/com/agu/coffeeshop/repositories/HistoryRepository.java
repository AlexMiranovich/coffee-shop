package com.agu.coffeeshop.repositories;

import com.agu.coffeeshop.entities.History;

import java.util.List;

public interface HistoryRepository {

    void insert(History history);

    List<History> findAllByParentId(String parentId);
}
