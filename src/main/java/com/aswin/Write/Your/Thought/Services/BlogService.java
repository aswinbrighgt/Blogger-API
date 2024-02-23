package com.aswin.Write.Your.Thought.Services;

import com.aswin.Write.Your.Thought.Dtos.BlogResponse;
import com.aswin.Write.Your.Thought.Dtos.CreateBlogRequest;
import com.aswin.Write.Your.Thought.Dtos.UpdateBlogRequest;
import com.aswin.Write.Your.Thought.Exceptions.RecordNotFoundException;
import com.aswin.Write.Your.Thought.Exceptions.UnauthorizedfunctionException;
import com.aswin.Write.Your.Thought.Models.Blog;
import com.aswin.Write.Your.Thought.Models.User;
import com.aswin.Write.Your.Thought.Repositories.BlogRepository;
import com.aswin.Write.Your.Thought.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BlogService {
    UserRepository userRepository;
    BlogRepository blogRepository;
    @Transactional
    public BlogResponse createBlog(CreateBlogRequest createBlogRequest, String username) {
        User user=userRepository.findById(createBlogRequest.getUserId()).
                orElseThrow(()->new RecordNotFoundException("user details not found in database"));
        if(!username.equals(user.getUsername())) throw
                new UnauthorizedfunctionException("you are not authorized for this function");
        Blog blog=new Blog();
        BeanUtils.copyProperties(createBlogRequest,blog);
        blog.setCreatedAt(LocalDateTime.now());
        blog.setUpdatedAt(LocalDateTime.now());
        blog.setUser(user);
        user.addblogs(blog);
        return getBlogResponse(blogRepository.save(blog));
    }
    @Transactional
    public BlogResponse updateBlog(UpdateBlogRequest updateBlogRequest,String userName) {
        Blog blog=blogRepository.findById(updateBlogRequest.getBlogId()).
                orElseThrow(()->new RecordNotFoundException("No blog found in database"));
        if(!userName.equals(blog.getUser().getUsername()))
            throw new UnauthorizedfunctionException("you are not accessed for this page");
        BeanUtils.copyProperties(updateBlogRequest,blog);
        blog.setUpdatedAt(LocalDateTime.now());
        return getBlogResponse(blogRepository.save(blog));
    }

    public BlogResponse searchBlog(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() ->
                new RecordNotFoundException("Blog not present in database"));
        return getBlogResponse(blog);
    }

    public List<BlogResponse> searchBlogsByTittle (String title) {
        List<Blog> blogs = blogRepository.findBlogsByTitle(title).orElse(new ArrayList<>());
        if(blogs.isEmpty())
                throw new RecordNotFoundException("no blogs found with the title");
        return blogs.stream()
                .map(this::getBlogResponse).toList();
    }
    public Object deleteBlog(Long id, String username) {
        Blog blog=blogRepository.findById(id).orElseThrow
                (()->new RecordNotFoundException("no blogs found with the id"));
        if(!username.equals(blog.getUser().getUsername()))
            throw new UnauthorizedfunctionException("you are not accessed for this page");
        blogRepository.delete(blog);
        return "bolg deleted";
    }
    private BlogResponse getBlogResponse(Blog blog) {
        BlogResponse blogResponse=new BlogResponse();
        BeanUtils.copyProperties(blog,blogResponse);
        blogResponse.setUsername(blog.getUser().getUsername());
        return blogResponse;
    }


}
