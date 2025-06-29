package com.example.club.user.service;

import com.example.club.crud.CRUDAbstractService;
import com.example.club.user.db.UserEntity;
import com.example.club.user.model.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService extends CRUDAbstractService<UserDTO, UserEntity> {
}
