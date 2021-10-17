package com.anz.sb.exception;

import com.anz.sb.model.SbResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<SbResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        log.debug("Inside handleMethodArgumentNotValidException method");
        List<String> errorList = e.getBindingResult().getFieldErrors().stream().map(err -> err.getDefaultMessage()).distinct().collect(Collectors.toList());
        return new ResponseEntity<>(SbResponse.builder().maxHeight(null).errorList(errorList).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<SbResponse> handleNullPointerException(NullPointerException e){
        log.debug("Inside handleMethodArgumentNotValidException method");
        return new ResponseEntity<>(SbResponse.builder().maxHeight(null).errorList(Arrays.asList("Bad Request")).build(), HttpStatus.BAD_REQUEST);
    }
}
