package com.example.club.userClub.model;

import com.example.club.club.model.ClubDTO;
import com.example.club.user.model.UserDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MemberDTO {
    private ClubDTO club;
    private List<UserDTO> list;
}
