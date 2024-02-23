package com.aswin.Write.Your.Thought.Services;

import com.aswin.Write.Your.Thought.Dtos.UpdateCommentRequest;
import com.aswin.Write.Your.Thought.Dtos.addCommentRequest;
import com.aswin.Write.Your.Thought.Exceptions.RecordNotFoundException;
import com.aswin.Write.Your.Thought.Exceptions.UnauthorizedfunctionException;
import com.aswin.Write.Your.Thought.Models.Blog;
import com.aswin.Write.Your.Thought.Models.Comment;
import com.aswin.Write.Your.Thought.Models.User;
import com.aswin.Write.Your.Thought.Repositories.BlogRepository;
import com.aswin.Write.Your.Thought.Repositories.CommentRepository;
import com.aswin.Write.Your.Thought.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service

public class CommentService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    CommentRepository commentRepository;

    public Object addComment(addCommentRequest addCommentRequest, String username) {
        User user=userRepository.findById(addCommentRequest.getUserid()).
                orElseThrow(()->new RecordNotFoundException("user id not present in Database"));
        if(!username.equals(user.getUsername())) throw
            new UnauthorizedfunctionException("Unauthorized request");
        Blog blog=blogRepository.findById(addCommentRequest.getBlogid()).
                orElseThrow(()->new RecordNotFoundException("blog id not present in Database"));
        Comment comment=commentRepository.save(
                new Comment(addCommentRequest.getComment(),user,blog,LocalDateTime.now()));
        userRepository.save(user.addComment(comment));
        blogRepository.save(blog.addComment(comment));
        return "Comment added Successfully";
    }

    public Object updateComment(UpdateCommentRequest updateCommentRequest,String username) {
        Comment comment=commentRepository.findById(updateCommentRequest.getCommentId()).
                orElseThrow(()->new RecordNotFoundException("Comment not present in Database"));
        if(!username.equals(comment.getUser().getUsername())) throw
                new UnauthorizedfunctionException("Unauthorized request");
        comment.setContent(updateCommentRequest.getToUpdate());
        comment.setUpdatedAt(LocalDateTime.now());
        commentRepository.save(comment);
        return "Comment Updated Successfully";
    }

    public Object deleteComment(Long id, String username) {
        Comment comment=commentRepository.findById(id).
                orElseThrow(()->new RecordNotFoundException("Comment not present in Database"));
        if(!username.equals(comment.getUser().getUsername())) throw
                new UnauthorizedfunctionException("Unauthorized request");
        commentRepository.delete(comment);
        return "Comment deleted Successfully";
    }
}

