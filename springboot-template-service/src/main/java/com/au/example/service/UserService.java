package com.au.example.service;


import com.au.example.dto.*;

import java.util.List;


public interface UserService {

    LoginOutputDTO login(LoginInputDTO loginInputDTO);

    CreateUserOutputDTO create(CreateUserInputDTO createUserInputDTO);

    List<UserDTO> getAllUser();


}
