package com.example.club.user.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDTO {
    private Long id;

    @NotBlank
    @Size(min = 2, max = 10)
    private String name;

    private String status;

    @NotNull
    private Integer age;

    @NotBlank
    private String phone;

    @Email
    @NotBlank
    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
