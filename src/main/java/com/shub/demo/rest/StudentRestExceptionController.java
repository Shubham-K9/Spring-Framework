package com.shub.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionController {
    @ExceptionHandler
    public ResponseEntity<StudentResponseError> handleException(StudentNotFoundException exce){
        //create a StudentResponseError
        StudentResponseError err=new StudentResponseError();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(exce.getMessage());
        err.setTimestamp(System.currentTimeMillis());


        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler
    public ResponseEntity<StudentResponseError> handeleException(Exception exce){
        //create a StudentResponseError
        StudentResponseError err=new StudentResponseError();
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage(exce.getMessage());
        err.setTimestamp(System.currentTimeMillis());


        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);

    }

}
