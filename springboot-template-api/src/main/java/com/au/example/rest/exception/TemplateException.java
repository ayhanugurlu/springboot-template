package com.au.example.rest.exception;

/**
 *
 */
public abstract class TemplateException extends  Exception{

    public abstract  int getHttpStatusCode();

    public abstract  String getErrorCode();

    public abstract  String[] getApiErrors();

}
