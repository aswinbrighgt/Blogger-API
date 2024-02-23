package com.aswin.Write.Your.Thought.Dtos;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBlogRequest {
    @NotNull(message = "blog id is mandatory")
    private Long blogId;
    @NotBlank(message = "title is mandatory")
    private String title;
    @NotBlank(message = "description is mandatory")
    private String description;
}