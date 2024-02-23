package com.aswin.Write.Your.Thought.Exceptions;

import lombok.Getter;

@Getter
public class TokenAlreadyVerifiedException extends RuntimeException {
    static String message="token already verified";
}
