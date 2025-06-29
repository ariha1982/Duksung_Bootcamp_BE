package com.example.simpleboard.post.service;

import com.example.simpleboard.post.db.PostEntity;
import com.example.simpleboard.post.model.PostDTO;
import org.springframework.stereotype.Service;

@Service
public class PostConverter {

    public PostDTO toDto(PostEntity postEntity) {
        return PostDTO.builder()
                .id(postEntity.getId())
                .userName(postEntity.getUserName())
                .password(postEntity.getPassword())
                .email(postEntity.getEmail())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .status(postEntity.getStatus())
                .postedAt(postEntity.getPostedAt())
                .boardId(postEntity.getBoard().getId())
                .build();
    }
}
