package com.aswin.Write.Your.Thought.Dtos;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBlogRequest {
    @NotBlank(message = "Tittle must be needed")
    private String title;
    @NotBlank (message = "description not to be empty")
    private String description;
    @NotNull(message = "user id in mandatory")
    private Long userId;
}
