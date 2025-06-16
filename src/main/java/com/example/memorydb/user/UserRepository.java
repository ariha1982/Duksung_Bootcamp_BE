package com.example.memorydb.user;

import com.example.memorydb.db.SimpleDataRepository;
import com.example.memorydb.user.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepository extends SimpleDataRepository<UserEntity, Long> {
    public List<UserEntity> findByScore(int score) {
        return this.findAll().stream()
                .filter(it -> {
                    return it.getScore() >= score;
                })
                .toList();
    }
}
