package com.example.club.user.controller;

import com.example.club.crud.CRUDAbstractApiController;
import com.example.club.user.db.UserEntity;
import com.example.club.user.model.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController extends CRUDAbstractApiController<UserDTO, UserEntity> {
}
