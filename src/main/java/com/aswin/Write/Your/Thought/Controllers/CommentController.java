package com.aswin.Write.Your.Thought.Controllers;

import com.aswin.Write.Your.Thought.Dtos.*;
import com.aswin.Write.Your.Thought.Services.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Validated
@RestController
@RequestMapping("/v1/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody addCommentRequest addCommentRequest,Authentication authentication){
        String username=authentication.getName();
        return Response.getResponseEntity
                (commentService.addComment(addCommentRequest,username),
                        "Comment saved successfully");
    }

    @PutMapping("/update/")
    public ResponseEntity update
            (@Valid @RequestBody UpdateCommentRequest updateCommentRequest, Authentication authentication){
        String username=authentication.getName();
        return Response.getResponseEntity
                (commentService.updateComment(updateCommentRequest,username),"Comment updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete
            (@PathVariable("id") Long id, Authentication authentication){
        String username=authentication.getName();
        return Response.getResponseEntity
                (commentService.deleteComment(id,username),"Comment deleted successfully");
    }

}
