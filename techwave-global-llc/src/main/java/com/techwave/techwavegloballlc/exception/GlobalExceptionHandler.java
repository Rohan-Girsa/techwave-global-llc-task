package com.techwave.techwavegloballlc.exception;

import com.techwave.techwavegloballlc.response.ResponseWrapper;
import com.techwave.techwavegloballlc.response.StatusDescription;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseWrapper> handleNotFoundException(NotFoundException ex){
        StatusDescription statusDescription = StatusDescription.builder().statusCode(404).statusMessage(ex.getMessage()).build();
        return new ResponseEntity<>(ResponseWrapper.builder().statusDescription(statusDescription).build(), HttpStatus.OK);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseWrapper> handleGenericException(Exception ex){
        StatusDescription statusDescription = StatusDescription.builder().statusCode(500).statusMessage(ex.getMessage()).build();
        return new ResponseEntity<>(ResponseWrapper.builder().statusDescription(statusDescription).build(), HttpStatus.OK);
    }
}
