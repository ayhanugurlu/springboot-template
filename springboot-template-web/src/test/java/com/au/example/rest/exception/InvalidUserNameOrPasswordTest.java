package com.au.example.rest.exception;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;


public class InvalidUserNameOrPasswordTest {

    @Test
    public void errorMessageTest(){
        InvalidUserNameOrPassword invalidUserNameOrPassword = new InvalidUserNameOrPassword();
        Assert.assertEquals(invalidUserNameOrPassword.getErrorCode(), HttpStatus.UNAUTHORIZED.name());
        Assert.assertEquals(invalidUserNameOrPassword.getHttpStatusCode(), HttpStatus.UNAUTHORIZED.value());
    }

}
