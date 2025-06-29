package com.example.simpleboard.board.model;

import com.example.simpleboard.post.model.PostDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BoardDTO {
    private Long id;

    private String boardName;

    private String status;

    private List<PostDTO> postList = List.of();
}
