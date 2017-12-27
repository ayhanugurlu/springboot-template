package com.au.example.rest.exception;

import org.springframework.http.HttpStatus;

public class InvalidUserNameOrPassword  extends TemplateException {

    @Override
    public int getHttpStatusCode() {
        return HttpStatus.UNAUTHORIZED.value();
    }

    @Override
    public String getErrorCode() {
        return HttpStatus.UNAUTHORIZED.name();
    }

    @Override
    public String[] getApiErrors() {
        return new String[0];
    }
}
