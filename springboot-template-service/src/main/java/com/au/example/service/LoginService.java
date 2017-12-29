package com.au.example.service;


import com.au.example.dto.*;


public interface LoginService {

    LoginOutputDTO login(LoginInputDTO loginInputDTO);

    CreateUserOutputDTO create(CreateUserInputDTO createUserInputDTO);


}
