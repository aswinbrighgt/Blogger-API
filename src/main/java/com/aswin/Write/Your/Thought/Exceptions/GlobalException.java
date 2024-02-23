package com.aswin.Write.Your.Thought.Exceptions;

import com.aswin.Write.Your.Thought.Dtos.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleValidationException
            (MethodArgumentNotValidException ex){
        Response dbs=new Response();
        dbs.setMessgae(ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(dbs,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Response> handleRecordNotFoundExceptions(RecordNotFoundException ex){
    Response dbs=new Response();
    dbs.setMessgae(ex.getMessage());
    return new ResponseEntity<>(dbs, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyRegisteredException.class)
    public ResponseEntity handleUserAlreadyRegistered(UserAlreadyRegisteredException ex){
        Response dbs=new Response<>();
        dbs.setMessgae(ex.getMessage());
        return new ResponseEntity<>(dbs,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UnauthorizedfunctionException.class)
    public ResponseEntity handelUnauthorizedfunctionException(UnauthorizedfunctionException ex){
        return new ResponseEntity<>(new Response<>(null,ex.getMessage()),HttpStatus.UNAUTHORIZED);
    }

}
