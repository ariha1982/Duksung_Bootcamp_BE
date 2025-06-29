package com.example.club.userClub.db;

import com.example.club.club.db.ClubEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserClubRepository extends JpaRepository<UserClubEntity, Long> {
    List<UserClubEntity> findAllByClubOrderByIdDesc(ClubEntity club);
}
