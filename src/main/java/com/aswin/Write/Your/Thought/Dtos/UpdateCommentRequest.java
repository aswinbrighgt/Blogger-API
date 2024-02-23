package com.aswin.Write.Your.Thought.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCommentRequest {

    @NotNull
    private Long commentId;

    @NotBlank
    private String toUpdate;
}
