package com.au.example.exception;

import static com.au.example.common.Constants.DUBLICATE_USER_MESSAGE;
import static com.au.example.common.Constants.INVALID_USER_NAME_OR_PASS;
import static com.au.example.common.Constants.INVALID_USER_NAME_OR_PASS_ERR_CODE;

public class InvalidUserNameOrPassword  extends TemplateException {




    public InvalidUserNameOrPassword(){
        super();
        errors.add(INVALID_USER_NAME_OR_PASS);

    }




    @Override
    public String getErrorCode() {
        return INVALID_USER_NAME_OR_PASS_ERR_CODE;
    }

}
