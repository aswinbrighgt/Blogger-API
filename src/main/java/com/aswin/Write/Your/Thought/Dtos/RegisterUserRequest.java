package com.aswin.Write.Your.Thought.Dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @Email
    private String mail;
    @NotBlank
    private String mobile;
}
