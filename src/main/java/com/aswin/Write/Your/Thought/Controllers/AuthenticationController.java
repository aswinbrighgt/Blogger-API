package com.aswin.Write.Your.Thought.Controllers;

import com.aswin.Write.Your.Thought.Dtos.LoginRequest;
import com.aswin.Write.Your.Thought.Dtos.RegisterUserRequest;
import com.aswin.Write.Your.Thought.Dtos.Response;
import com.aswin.Write.Your.Thought.Services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/v1/authentication")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody RegisterUserRequest request) {
        return Response.getResponseEntity
                (authenticationService.register(request),"User Registered Successfully");
    }
    @GetMapping("/login")
    public ResponseEntity login(@Valid @RequestBody LoginRequest request) {
        return Response.getResponseEntity
                (authenticationService.login(request),"User successfully logged in");
    }

}
