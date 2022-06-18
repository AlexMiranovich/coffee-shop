package com.agu.coffeeshop.services.impl;

import com.agu.coffeeshop.entities.User;
import com.agu.coffeeshop.repositories.impl.BaseRepository;
import com.agu.coffeeshop.services.HistoryService;
import com.agu.coffeeshop.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService<User> implements UserService {

    public UserServiceImpl(BaseRepository<User> baseRepository, HistoryService historyService) {
        super(baseRepository, historyService);
    }
}
