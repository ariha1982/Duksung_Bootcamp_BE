package com.example.club.userClub.controller;

import com.example.club.crud.CRUDAbstractApiController;
import com.example.club.userClub.db.UserClubEntity;
import com.example.club.userClub.model.MemberDTO;
import com.example.club.userClub.model.UserClubDTO;
import com.example.club.userClub.service.UserClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class UserClubController extends CRUDAbstractApiController<UserClubDTO, UserClubEntity> {
    private final UserClubService userClubService;

    @GetMapping("/club/{id}")
    public MemberDTO getAllMemberByClub(@PathVariable Long id) {
        return userClubService.getMemberList(id);
    }
}
