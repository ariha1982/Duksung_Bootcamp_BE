package com.example.club.user.service;

import com.example.club.crud.Converter;
import com.example.club.user.db.UserEntity;
import com.example.club.user.db.UserRepository;
import com.example.club.user.model.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserConverter implements Converter<UserDTO, UserEntity> {

    @Override
    public UserDTO toDto(UserEntity userEntity) {
        return UserDTO.builder()
            .id(userEntity.getId())
            .name(userEntity.getName())
            .status(userEntity.getStatus())
            .age(userEntity.getAge())
            .email(userEntity.getEmail())
            .phone(userEntity.getPhone())
            .createdAt(userEntity.getCreatedAt())
            .updatedAt(userEntity.getUpdatedAt())
            .build();
    }

    @Override
    public UserEntity toEntity(UserDTO userDTO) {
        LocalDateTime current = LocalDateTime.now();

        return UserEntity.builder()
            .id(userDTO.getId())
            .name(userDTO.getName())
            .status(userDTO.getStatus() != null ? userDTO.getStatus() : "ACTIVATE")
            .age(userDTO.getAge())
            .phone(userDTO.getPhone())
            .email(userDTO.getEmail())
            .createdAt(userDTO.getCreatedAt() != null ? userDTO.getCreatedAt() : current)
            .updatedAt(userDTO.getUpdatedAt() != null ? userDTO.getUpdatedAt() : current)
            .build();
    }

    @Override
    public Long getId(UserDTO userDTO) {
        return userDTO.getId();
    }

    @Override
    public UserEntity updateEntity(UserEntity userEntity, UserDTO userDTO) {

        userEntity.setName(userDTO.getName());
        userEntity.setAge(userDTO.getAge());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPhone(userDTO.getPhone());
        userEntity.setUpdatedAt(LocalDateTime.now());

        return userEntity;
    }
}
