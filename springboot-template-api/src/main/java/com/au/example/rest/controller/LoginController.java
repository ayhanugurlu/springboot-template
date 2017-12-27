package com.au.example.rest.controller;

import com.au.example.dto.LoginInputDTO;
import com.au.example.dto.LoginOutputDTO;
import com.au.example.rest.common.Constants;
import com.au.example.rest.exception.InvalidUserNameOrPassword;
import com.au.example.rest.model.req.LoginReq;
import com.au.example.rest.model.resp.LoginResp;


import com.au.example.service.LoginService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    @Qualifier("loginControllerMapper")
    private MapperFacade mapperFacade;

    @Autowired
    private Tracer tracer;


    @Autowired
    private LoginService loginService;




    @ApiOperation(value = "login user ",
            notes = "login user into the template application.<br/>")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<LoginResp> loginUsers(@ApiParam(value = "username and password") @RequestBody LoginReq loginRequest) throws InvalidUserNameOrPassword {
        logger.debug("loginUsers method start", tracer.getCurrentSpan().getTraceId());
        LoginInputDTO loginInputDTO  = mapperFacade.map(loginRequest, LoginInputDTO.class);
        LoginOutputDTO loginOutputDTO = loginService.login(loginInputDTO);
        LoginResp loginResp  = mapperFacade.map(loginOutputDTO, LoginResp.class);
        logger.debug("loginUsers method finish", tracer.getCurrentSpan().getTraceId());
        return ResponseEntity.status(HttpStatus.OK).header(Constants.TRACER_ID,String.valueOf(tracer.getCurrentSpan().getTraceId())).body(loginResp);
    }

}
