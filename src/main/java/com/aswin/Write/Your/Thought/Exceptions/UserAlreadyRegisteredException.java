package com.aswin.Write.Your.Thought.Exceptions;

import lombok.Getter;

@Getter
public class UserAlreadyRegisteredException extends RuntimeException {

    private String message;
    public UserAlreadyRegisteredException(String message) {
        this.message=message;
    }
}
