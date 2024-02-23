package com.aswin.Write.Your.Thought.Exceptions;

import lombok.Getter;

@Getter
public class TokenAlreadyExpiredException extends RuntimeException {
    static String message="Token expired";

}
