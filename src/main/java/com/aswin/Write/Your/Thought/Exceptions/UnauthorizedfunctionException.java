package com.aswin.Write.Your.Thought.Exceptions;

import lombok.Getter;

@Getter
public class UnauthorizedfunctionException extends RuntimeException {

    String message;
    public UnauthorizedfunctionException(String s) {
        this.message=s;
    }
}
