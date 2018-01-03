package com.au.example.exception;


import com.au.example.common.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;


public class InvalidUserNameOrPasswordTest {

    @Test
    public void errorMessageTest(){
        InvalidUserNameOrPassword invalidUserNameOrPassword = new InvalidUserNameOrPassword();
        Assert.assertEquals(invalidUserNameOrPassword.getErrorCode(), Constants.INVALID_USER_NAME_OR_PASS_ERR_CODE);
    }

}
