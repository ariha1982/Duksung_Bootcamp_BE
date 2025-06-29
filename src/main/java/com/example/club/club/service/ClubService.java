package com.example.club.club.service;

import com.example.club.club.db.ClubEntity;
import com.example.club.club.model.ClubDTO;
import com.example.club.crud.CRUDAbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClubService extends CRUDAbstractService<ClubDTO, ClubEntity> {
}
