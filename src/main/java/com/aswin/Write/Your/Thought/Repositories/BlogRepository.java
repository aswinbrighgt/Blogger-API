package com.aswin.Write.Your.Thought.Repositories;

import com.aswin.Write.Your.Thought.Models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    Optional<List<Blog>> findBlogsByTitle(String Title);
}
