package com.aswin.Write.Your.Thought.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class addCommentRequest {
    @NotNull
    private Long userid;
    @NotNull
    private Long blogid;
    @NotBlank
    private String comment;
}
