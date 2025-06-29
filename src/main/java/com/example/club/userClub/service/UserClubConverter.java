package com.example.club.userClub.service;

import com.example.club.club.db.ClubEntity;
import com.example.club.club.db.ClubRepository;
import com.example.club.crud.Converter;
import com.example.club.user.db.UserEntity;
import com.example.club.user.db.UserRepository;
import com.example.club.userClub.db.UserClubEntity;
import com.example.club.userClub.model.UserClubDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserClubConverter implements Converter<UserClubDTO, UserClubEntity> {
    private final UserRepository userRepository;
    private final ClubRepository clubRepository;

    @Override
    public UserClubDTO toDto(UserClubEntity userClubEntity) {
        return UserClubDTO.builder()
            .id(userClubEntity.getId())
            .userId(userClubEntity.getUser().getId())
            .clubId(userClubEntity.getClub().getId())
            .build();
    }

    @Override
    public UserClubEntity toEntity(UserClubDTO userClubDTO) {
        UserEntity user = userRepository.findById(userClubDTO.getUserId())
            .orElseThrow(() -> new RuntimeException("해당 유저가 존재하지 않습니다."));

        ClubEntity club = clubRepository.findById(userClubDTO.getClubId())
            .orElseThrow(() -> new RuntimeException("해당 동아리가 존재하지 않습니다."));

        return UserClubEntity.builder()
            .id(userClubDTO.getId())
            .user(user)
            .club(club)
            .build();
    }

    @Override
    public Long getId(UserClubDTO userClubDTO) {
        return null;
    }

    @Override
    public UserClubEntity updateEntity(UserClubEntity userClubEntity, UserClubDTO userClubDTO) {
        return null;
    }
}
