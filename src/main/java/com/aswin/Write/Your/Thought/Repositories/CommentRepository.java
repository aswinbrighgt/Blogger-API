package com.aswin.Write.Your.Thought.Repositories;

import com.aswin.Write.Your.Thought.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

}
