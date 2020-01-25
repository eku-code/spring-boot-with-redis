package com.gun.entry.repository;

import com.gun.entry.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {


    private static final String HASH_KEY = "USER";

    private RedisTemplate<String, User> redisTemplate;

    private HashOperations<String, String, User> hashOperations;

    @Autowired
    public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
        hashOperations.put(HASH_KEY, user.getId(), user);
    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries(HASH_KEY);
    }

    @Override
    public User findById(String id) {
        return hashOperations.get(HASH_KEY, id);
    }

    @Override
    public void deleteById(String id) {
        hashOperations.delete(HASH_KEY, id);
    }
}
