package com.springBootDemo.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidationsRules extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String,String> map=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(objectError ->{
            String fieldName=((FieldError)objectError).getField();
            String message=objectError.getDefaultMessage();
            map.put(fieldName,message);
        } );
        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
    }


}
