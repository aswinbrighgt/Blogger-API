package com.aswin.Write.Your.Thought.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Blog extends BaseModel{
    private String title;
    @Lob
    private String description;

    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "blog")
    List<Comment> comments=new ArrayList<>();

    public Blog addComment(Comment comment){
        comments.add(comment);
        return this;
    }
}
