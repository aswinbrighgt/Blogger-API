package com.aswin.Write.Your.Thought.Exceptions;

import lombok.Getter;

@Getter
public class TokenNotFoundException extends RuntimeException {
    static String message="Token not found";

}
