package com.aswin.Write.Your.Thought.Dtos;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter

public class BlogResponse{
    private String title;
    private String description;
    private Long Id;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
