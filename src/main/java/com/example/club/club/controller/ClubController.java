package com.example.club.club.controller;

import com.example.club.club.db.ClubEntity;
import com.example.club.club.model.ClubDTO;
import com.example.club.crud.CRUDAbstractApiController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/club")
@RequiredArgsConstructor
public class ClubController extends CRUDAbstractApiController<ClubDTO, ClubEntity> {
}
