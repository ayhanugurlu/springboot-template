package com.au.example.rest.controller;

import com.au.example.dto.*;
import com.au.example.rest.exception.InvalidUserNameOrPassword;
import com.au.example.rest.model.req.CreateUserReq;
import com.au.example.rest.model.req.LoginReq;
import com.au.example.rest.model.resp.CreateUserResp;
import com.au.example.rest.model.resp.LoginResp;
import com.au.example.rest.model.resp.UserInfoResp;
import com.au.example.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    @Qualifier("loginControllerMapper")
    private MapperFacade mapperFacade;

    @Autowired
    private Tracer tracer;


    @Autowired
    private UserService userService;


    @ApiOperation(value = "login user ",
            notes = "login user into the template application.<br/>")
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    LoginResp loginUsers(@ApiParam(value = "username and password") @RequestBody LoginReq loginRequest) throws InvalidUserNameOrPassword {
        logger.debug("loginUsers method start", tracer.getCurrentSpan().getTraceId());
        LoginInputDTO loginInputDTO = mapperFacade.map(loginRequest, LoginInputDTO.class);
        LoginOutputDTO loginOutputDTO = userService.login(loginInputDTO);
        LoginResp loginResp = mapperFacade.map(loginOutputDTO, LoginResp.class);
        logger.debug("loginUsers method finish", tracer.getCurrentSpan().getTraceId());
        return loginResp;
    }


    @ApiOperation(value = "create user ",
            notes = "create user into the template application.<br/>")
    @RequestMapping(value = "/sign-up", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    CreateUserResp createUsers(@ApiParam(value = "username and password") @RequestBody CreateUserReq createUserReq) throws InvalidUserNameOrPassword {
        logger.debug("createUsers method start", tracer.getCurrentSpan().getTraceId());
        CreateUserInputDTO createUserInputDTO = mapperFacade.map(createUserReq, CreateUserInputDTO.class);
        CreateUserOutputDTO createUserOutputDTO = userService.create(createUserInputDTO);
        CreateUserResp createUserResp = mapperFacade.map(createUserOutputDTO, CreateUserResp.class);
        logger.debug("createUsers method finish", tracer.getCurrentSpan().getTraceId());
        return createUserResp;
    }


    @ApiOperation(value = "get all user ",
            notes = "get all user information template application.<br/>")
    @RequestMapping(value = "/infos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    List<UserInfoResp> getUsers() {
        logger.debug("getUsers method start", tracer.getCurrentSpan().getTraceId());
        List<UserDTO> userDTOS = userService.getAllUser();
        List<UserInfoResp> userInfoResps = mapperFacade.mapAsList(userDTOS, UserInfoResp.class);
        logger.debug("getUsers method finish", tracer.getCurrentSpan().getTraceId());
        return userInfoResps;
    }

}
