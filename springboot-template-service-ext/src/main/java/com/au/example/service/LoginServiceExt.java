package com.au.example.service;


import com.au.example.dto.*;


public interface LoginServiceExt {

    UserDTO findByUsername(String userName);
}
