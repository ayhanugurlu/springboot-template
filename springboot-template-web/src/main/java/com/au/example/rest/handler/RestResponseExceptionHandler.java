package com.au.example.rest.handler;

import com.au.example.exception.DuplicateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {


    @Value("${error.code.header.key}")
    private String errorCodeHeaderKey;


    @Autowired
    private Tracer tracer;

    @ExceptionHandler(DuplicateUser.class)
    public ResponseEntity<ErrResponse> handleValidationException(HttpServletRequest request, DuplicateUser e) {

        String errorMessage = e.getErrors().stream().collect(Collectors.joining(", "));
        String[] eCodes = {e.getErrorCode()};

        logger.error(errorMessage);
        ErrResponse response = new ErrResponse(tracer.getCurrentSpan().getTraceId(), errorMessage);


        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .header(errorCodeHeaderKey, eCodes)
                .body(response);
    }
}