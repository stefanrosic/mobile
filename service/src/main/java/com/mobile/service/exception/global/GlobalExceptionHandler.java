package com.mobile.service.exception.global;

import com.mobile.service.dto.response.ErrorResponse;
import com.mobile.service.exception.MobileAlreadyExistsException;
import com.mobile.service.exception.MobileNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MobileAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> processMobileAlreadyExistsException(MobileAlreadyExistsException e) {
        logException(e);
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ErrorResponse.builder().message(e.getMessage()).build());
    }

    @ExceptionHandler(MobileNotFoundException.class)
    public ResponseEntity<ErrorResponse> processMobileNotFoundException(MobileNotFoundException e) {
        logException(e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.builder().message(e.getMessage()).build());
    }

    private void logException(Exception e) {
        log.error(e.getClass().getSimpleName() + " thrown", e);
    }
}
