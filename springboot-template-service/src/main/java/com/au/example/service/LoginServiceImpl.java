package com.au.example.service;


import com.au.example.common.SessionState;
import com.au.example.dto.LoginInputDTO;
import com.au.example.dto.LoginOutputDTO;
import com.au.example.mongo.User;
import com.au.example.mongo.UserSession;
import com.au.example.repository.UserRepository;
import com.au.example.repository.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserSessionRepository userSessionRepository;

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
            loginOutputDTO.setUserId(user.getId());
            loginOutputDTO.setUserSessionId(userSession.getToken());
            return loginOutputDTO;
        }
        return null;
    }
}
