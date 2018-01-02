package com.au.example.service;


import com.au.example.dto.*;
import com.au.example.exception.DuplicateUser;
import com.au.example.exception.InvalidUserNameOrPassword;

import java.util.List;


public interface UserService {

    LoginOutputDTO login(LoginInputDTO loginInputDTO) throws InvalidUserNameOrPassword;

    CreateUserOutputDTO create(CreateUserInputDTO createUserInputDTO) throws DuplicateUser;

    List<UserDTO> getAllUser();


}
