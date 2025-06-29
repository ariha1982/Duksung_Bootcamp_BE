package com.example.club.userClub.db;

import com.example.club.club.db.ClubEntity;
import com.example.club.user.db.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity(name = "user_club")
public class UserClubEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JsonIgnore
    @ToString.Exclude
    private UserEntity user;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private ClubEntity club;
}
