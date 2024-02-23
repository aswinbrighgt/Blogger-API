package com.aswin.Write.Your.Thought.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseModel{


    private String content;
    @ManyToOne
    private User user;
    @ManyToOne
    private Blog blog;

    public Comment(String content, User user, Blog blog, LocalDateTime now){
        this.content=content;
        this.user=user;
        this.blog=blog;
        this.setCreatedAt(now);
        this.setUpdatedAt(now);
    }

}
