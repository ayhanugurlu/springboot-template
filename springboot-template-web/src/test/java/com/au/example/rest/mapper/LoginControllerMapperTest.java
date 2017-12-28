package com.au.example.rest.mapper;

import com.au.example.SpringBootTemplateWebApplication;
import com.au.example.dto.LoginInputDTO;
import com.au.example.rest.model.req.LoginReq;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SpringBootTemplateWebApplication.class)
public class LoginControllerMapperTest {

    @Autowired
    LoginControllerMapper loginControllerMapper;

    @Test
    public void shouldMapLoginReqtoLoginInputDTO() {
        LoginReq loginReq = new LoginReq("user", "pass");
        LoginInputDTO loginInputDTO = loginControllerMapper.map(loginReq, LoginInputDTO.class);
        Assert.assertEquals(loginInputDTO.getUsername(), loginReq.getUsername());
        Assert.assertEquals(loginInputDTO.getPassword(), loginReq.getPassword());
    }


}
