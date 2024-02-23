package com.aswin.Write.Your.Thought.Dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Response<T> {

    T data;
    String messgae;
    public Response(T data, String messgae){
        this.data=data;
        this.messgae=messgae;
    }
    public static <T> ResponseEntity<Response<T>> getResponseEntity(T blogs, String Message) {
        Response<T> response=new Response<T>();
        response.setData(blogs);
        response.setMessgae(Message);
        return ResponseEntity.ok(response);
    }

}
