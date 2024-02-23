package com.aswin.Write.Your.Thought.Services;

import com.aswin.Write.Your.Thought.Dtos.LoginRequest;
import com.aswin.Write.Your.Thought.Dtos.RegisterUserRequest;
import com.aswin.Write.Your.Thought.Models.Role;
import com.aswin.Write.Your.Thought.Models.User;
import com.aswin.Write.Your.Thought.Repositories.UserRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthenticationService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    JwtService jwtService;
    @Autowired
    AuthenticationManager authenticationManager;

    public String register(RegisterUserRequest request) {
        Optional<User> user=userRepository.findUserByUsername(request.getMail());
        if(!ObjectUtils.isEmpty(user)) return "User already Present";
        User newUser = new User();
        newUser.setUsername(request.getMail());
        newUser.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        newUser.setRole(Role.USER);
        newUser.setMobile(request.getMobile());
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setUpdatedAt(LocalDateTime.now());
        newUser.setName(request.getName());
        userRepository.save(newUser);
        return jwtService.generateToken(newUser);
    }
    public String login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        Optional<User> user=userRepository.findUserByUsername(request.getUsername());
        return jwtService.generateToken(user.get());
    }
}
