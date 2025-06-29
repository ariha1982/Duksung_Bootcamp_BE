package com.example.club.userClub.service;

import com.example.club.club.db.ClubEntity;
import com.example.club.club.db.ClubRepository;
import com.example.club.club.service.ClubConverter;
import com.example.club.crud.CRUDAbstractService;
import com.example.club.user.db.UserEntity;
import com.example.club.user.db.UserRepository;
import com.example.club.user.model.UserDTO;
import com.example.club.user.service.UserConverter;
import com.example.club.userClub.db.UserClubEntity;
import com.example.club.userClub.db.UserClubRepository;
import com.example.club.userClub.model.MemberDTO;
import com.example.club.userClub.model.UserClubDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserClubService extends CRUDAbstractService<UserClubDTO, UserClubEntity> {
    private final ClubRepository clubRepository;
    private final UserClubRepository userClubRepository;
    private final ClubConverter clubConverter;
    private final UserConverter userConverter;

    public MemberDTO getMemberList(Long id) {
        ClubEntity club = clubRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("해당 동아리가 존재하지 않습니다."));

        List<UserClubEntity> memberList = userClubRepository.findAllByClubOrderByIdDesc(club);
        List<UserDTO> userList = memberList.stream().map(it -> userConverter.toDto(it.getUser())).toList();

        return MemberDTO.builder()
            .club(clubConverter.toDto(club))
            .list(userList)
            .build();
    }
}
