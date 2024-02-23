package com.aswin.Write.Your.Thought.Exceptions;

import lombok.Getter;

import java.util.function.Supplier;

@Getter
public class RecordNotFoundException extends RuntimeException {
    String message;
    public RecordNotFoundException(String message){
        this.message=message;
    }

}
