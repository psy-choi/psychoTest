package com.example.pyschoTest.exception;


import com.example.pyschoTest.dto.ResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.MethodNotAllowedException;

@RestControllerAdvice
@Log4j2
public class exceptionHandler {

    @ExceptionHandler(customException.class)
    protected ResponseEntity customExceptionHandler(customException exception) {
        return new ResponseEntity(new ResponseDto(-1, exception.getMessage(), 0), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodNotAllowedException.class)
    protected ResponseEntity methodnotAllowedExceptionHandler(MethodNotAllowedException exception){
        return new ResponseEntity(new ResponseDto(-1, exception.getMessage(), 0), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity httpMethodnotAllowedExceptionHandler(HttpRequestMethodNotSupportedException exception){
        return new ResponseEntity(new ResponseDto(-1, exception.getMessage(), 0), HttpStatus.METHOD_NOT_ALLOWED);
    }
}
