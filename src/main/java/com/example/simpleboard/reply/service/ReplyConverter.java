package com.example.simpleboard.reply.service;

import com.example.simpleboard.crud.Converter;
import com.example.simpleboard.post.db.PostRepository;
import com.example.simpleboard.reply.db.ReplyEntity;
import com.example.simpleboard.reply.model.ReplyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReplyConverter implements Converter<ReplyDTO, ReplyEntity> {
    private final PostRepository postRepository;

    @Override
    public ReplyDTO toDto(ReplyEntity replyEntity) {
        return ReplyDTO.builder()
            .id(replyEntity.getId())
            .postId(replyEntity.getPost().getId())
            .status(replyEntity.getStatus())
            .title(replyEntity.getTitle())
            .content(replyEntity.getContent())
            .userName(replyEntity.getUserName())
            .password(replyEntity.getPassword())
            .repliedAt(replyEntity.getRepliedAt())
            .build();
    }

    @Override
    public ReplyEntity toEntity(ReplyDTO replyDTO) {
        var postEntity = postRepository.findById(replyDTO.getPostId());

        return ReplyEntity.builder()
            .id(replyDTO.getId())
            .post(postEntity.orElse(null))
            .status((replyDTO.getStatus() != null) ? replyDTO.getStatus() : "REGISTERED")
            .title(replyDTO.getTitle())
            .content(replyDTO.getContent())
            .userName(replyDTO.getUserName())
            .password(replyDTO.getPassword())
            .repliedAt((replyDTO.getRepliedAt() != null) ? replyDTO.getRepliedAt() : LocalDateTime.now())
            .build();
    }
}
