package com.au.example.service;


import com.au.example.common.SessionState;
import com.au.example.dto.*;
import com.au.example.mongo.User;
import com.au.example.mongo.UserSession;
import com.au.example.repository.UserRepository;
import com.au.example.repository.UserSessionRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService,LoginServiceExt {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserSessionRepository userSessionRepository;

    @Autowired
    @Qualifier("loginServiceMapper")
    MapperFacade mapperFacade;

    @Override
    public LoginOutputDTO login(LoginInputDTO loginInputDTO) {

        User user = userRepository.findByUsernameAndPassword(loginInputDTO.getUsername(), loginInputDTO.getPassword());
        if (user != null) {
            UserSession userSession = userSessionRepository.findByUserIdAndSessionState(user.getId(), SessionState.ACTIVE);
            if (userSession == null) {
                userSession = new UserSession();
                userSession.setUserId(user.getId());
                userSession.setSessionState(SessionState.ACTIVE);
                userSession.setToken(UUID.randomUUID().toString());
                userSessionRepository.save(userSession);
            }
            LoginOutputDTO loginOutputDTO = new LoginOutputDTO();
            loginOutputDTO.setToken("");

            return loginOutputDTO;
        }
        return null;
    }

    @Override
    public CreateUserOutputDTO create(CreateUserInputDTO createUserInputDTO) {
        User user = mapperFacade.map(createUserInputDTO, User.class);
        userRepository.save(user);
        CreateUserOutputDTO createUserOutputDTO = mapperFacade.map(user, CreateUserOutputDTO.class);
        return createUserOutputDTO;
    }

    @Override
    public UserDTO findByUsername(String userName) {
        User user = userRepository.findByUsername(userName);
        UserDTO userDTO = mapperFacade.map(user, UserDTO.class);
        return userDTO;
    }


}
