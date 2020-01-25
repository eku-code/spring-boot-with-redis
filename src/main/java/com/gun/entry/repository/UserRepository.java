package com.gun.entry.repository;

import com.gun.entry.domain.User;

import java.util.Map;

public interface UserRepository {

    void save(User user);
    Map<String, User> findAll();
    User findById(String id);
    void deleteById(String id);

}
