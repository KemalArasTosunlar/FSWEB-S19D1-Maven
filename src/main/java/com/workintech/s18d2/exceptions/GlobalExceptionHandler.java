package com.workintech.s18d2.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(PlantException.class)
    public ResponseEntity<PlantErrorResponse> handleException(PlantException ex){

        PlantErrorResponse error=new PlantErrorResponse(ex.getMessage());
        return new ResponseEntity<>(error,ex.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<PlantErrorResponse> handleException(Exception ex){

        PlantErrorResponse error=new PlantErrorResponse(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}