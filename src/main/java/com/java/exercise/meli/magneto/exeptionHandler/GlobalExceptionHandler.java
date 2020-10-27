package com.java.exercise.meli.magneto.exeptionHandler;

import com.java.exercise.meli.magneto.exeptionHandler.exeption.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<MessageError> exceptionHandler(Exception e){
        MessageError messageError=new MessageError("400",e.getMessage());
        messageError.setDate(new Date());
        messageError.setErrors("Bad Request");
        return new ResponseEntity<MessageError>(messageError, HttpStatus.BAD_REQUEST);
    }
}
