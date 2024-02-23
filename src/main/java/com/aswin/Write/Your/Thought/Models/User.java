package com.aswin.Write.Your.Thought.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseModel implements UserDetails {
    private String name;
    private String username;
    private String password;
    private String mobile;;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user")
    List<Blog> blogs=new ArrayList<>();
    @OneToMany(mappedBy = "user")
    List<Comment> comments=new ArrayList<>();
    public User addComment(Comment comment){
        comments.add(comment);
        return this;
    }
    public void addblogs(Blog blog){
        this.getBlogs().add(blog);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
