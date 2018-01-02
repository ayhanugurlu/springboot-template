package com.au.example.exception;


import static com.au.example.common.Constants.DUBLICATE_USER_ERR_CODE;
import static com.au.example.common.Constants.DUBLICATE_USER_MESSAGE;

public class DuplicateUser extends TemplateException {


    public DuplicateUser(String username) {
        super();
        errors.add(String.format(DUBLICATE_USER_MESSAGE, username));
    }


    @Override
    public String getErrorCode() {
        return DUBLICATE_USER_ERR_CODE;
    }


}
