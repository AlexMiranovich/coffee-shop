package com.agu.coffeeshop.services.impl;

import com.agu.coffeeshop.entities.History;
import com.agu.coffeeshop.repositories.HistoryRepository;
import com.agu.coffeeshop.services.HistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<History> findAllById(String id) {
        return historyRepository.findAllByParentId(id);
    }

    @Override
    public void save(String parentId, History.HistoryAction action, List<History.Change> changes) {
/*
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Principal principal = (Principal) authentication.getPrincipal();
        UserProfileModel userProfileModel = principal.getUserProfileModel();

        historyRepository.insert(History.builder()
                .time(Instant.now())
                .historyAction(action)
                .parentId(parentId)
                .userEmail(userProfileModel.getUserProfile().getEmail())
                .userName(userProfileModel.getUserProfile().getCommonName())
                .changeLog(changes)
                .build());
 */
    }
}
