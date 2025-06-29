package com.example.club.club.service;

import com.example.club.club.db.ClubEntity;
import com.example.club.club.db.ClubRepository;
import com.example.club.club.model.ClubDTO;
import com.example.club.crud.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ClubConverter implements Converter<ClubDTO, ClubEntity> {

    @Override
    public ClubDTO toDto(ClubEntity clubEntity) {
        return ClubDTO.builder()
            .id(clubEntity.getId())
            .name(clubEntity.getName())
            .description(clubEntity.getDescription() != null ? clubEntity.getDescription() : "")
            .createdAt(clubEntity.getCreatedAt())
            .updatedAt(clubEntity.getUpdatedAt())
            .build();
    }

    @Override
    public ClubEntity toEntity(ClubDTO clubDTO) {
        LocalDateTime current = LocalDateTime.now();

        return ClubEntity.builder()
            .id(clubDTO.getId())
            .name(clubDTO.getName())
            .description(clubDTO.getDescription())
            .createdAt(clubDTO.getCreatedAt() != null ? clubDTO.getCreatedAt() : current)
            .updatedAt(clubDTO.getUpdatedAt() != null ? clubDTO.getUpdatedAt() : current)
            .build();
    }

    @Override
    public Long getId(ClubDTO clubDTO) {
        return clubDTO.getId();
    }

    @Override
    public ClubEntity updateEntity(ClubEntity clubEntity, ClubDTO clubDTO) {

        clubEntity.setName(clubDTO.getName());
        clubEntity.setDescription(clubDTO.getDescription());
        clubEntity.setUpdatedAt(LocalDateTime.now());

        return clubEntity;
    }
}
