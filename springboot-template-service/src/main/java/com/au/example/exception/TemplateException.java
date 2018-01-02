package com.au.example.exception;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class TemplateException extends  Exception{

    protected List<String> errors = new ArrayList<>();

    public abstract  String getErrorCode();

    public List<String> getErrors(){
        return  errors;
    }

}
