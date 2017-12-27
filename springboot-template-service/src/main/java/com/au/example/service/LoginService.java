package com.au.example.service;


import com.au.example.dto.LoginInputDTO;
import com.au.example.dto.LoginOutputDTO;



public interface LoginService {

    LoginOutputDTO login(LoginInputDTO loginInputDTO);

}
