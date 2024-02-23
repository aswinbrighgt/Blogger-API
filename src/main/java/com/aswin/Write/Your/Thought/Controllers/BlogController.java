package com.aswin.Write.Your.Thought.Controllers;

import com.aswin.Write.Your.Thought.Dtos.CreateBlogRequest;
import com.aswin.Write.Your.Thought.Dtos.Response;
import com.aswin.Write.Your.Thought.Dtos.UpdateBlogRequest;
import com.aswin.Write.Your.Thought.Services.BlogService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Validated
@Slf4j
@RequestMapping("/v1/blog")
public class BlogController {


    BlogService blogService;

    @PostMapping("/createBlog")
    public ResponseEntity create(@Valid@RequestBody CreateBlogRequest createBlogRequest,Authentication authentication){
        String username=authentication.getName();
        return Response.getResponseEntity
                (blogService.createBlog(createBlogRequest,username),"Blog saved successfully");
    }

    @PutMapping("/updateBlog/")
    public ResponseEntity update(@Valid @RequestBody UpdateBlogRequest updateBlogRequest, Authentication authentication){
        String username=authentication.getName();
        return Response.getResponseEntity
                (blogService.updateBlog(updateBlogRequest,username),"Blog updated successfully");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity search(@PathVariable("id") Long id){
        return Response.getResponseEntity
                (blogService.searchBlog(id),"Blog fetched successfully");
    }

    @GetMapping("/search/Title/{title}")
    public ResponseEntity searchTittle(@PathVariable("title") String title){
        return Response.getResponseEntity
                (blogService.searchBlogsByTittle(title),"Blog's fetched successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog (@PathVariable("id") Long id,Authentication authentication){
        return Response.getResponseEntity
                (blogService.deleteBlog(id,authentication.getName()),"Blog deleted Succesfully");
    }


}
