package com.au.example.rest.controller;


import com.au.example.SpringBootTemplateWebApplication;
import com.au.example.dto.LoginInputDTO;
import com.au.example.dto.LoginOutputDTO;
import com.au.example.rest.model.req.LoginReq;
import com.au.example.rest.model.resp.LoginResp;
import com.au.example.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import ma.glasnost.orika.MapperFacade;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@WebMvcTest(controllers  =LoginController.class,secure = false)
@ContextConfiguration(classes = SpringBootTemplateWebApplication.class)
public class LoginControllerTest {

    @MockBean(name = "loginControllerMapper")
    MapperFacade mapperFacade;

    @Autowired
    private MockMvc mvc;


    @MockBean
    private Tracer tracer;

    @MockBean
    private Span span;

    @MockBean
    UserService userService;


    @Autowired
    @InjectMocks
    LoginController loginController;



    private LoginReq loginReq;

    @Before
    public void setupMock(){
        //ReflectionTestUtils.setField(userService,"mapperFacade",loginControllerMapper);

        LoginOutputDTO loginOutputDTO = new LoginOutputDTO();
        loginOutputDTO.setToken("token");


        loginReq = new LoginReq();
        loginReq.setUsername("userid");
        loginReq.setPassword("pass");

        LoginInputDTO loginInputDTO = new LoginInputDTO();
        loginInputDTO.setUsername("userid");
        loginInputDTO.setPassword("pass");


        LoginResp loginResp = new LoginResp();
        loginResp.setToken("token");


        when(mapperFacade.map(loginReq, LoginInputDTO.class)).thenReturn(loginInputDTO);
        when(userService.login(any(LoginInputDTO.class))).thenReturn(loginOutputDTO);
        when(mapperFacade.map(loginOutputDTO, LoginResp.class)).thenReturn(loginResp);

        when(span.getTraceId()).thenReturn(1l);

        when(tracer.getCurrentSpan()).thenReturn(span);
    }


    @Test
    public void loginUsers() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = this.mvc.perform(post("/login").content(mapper.writeValueAsBytes(loginReq)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn();

        LoginResp result = mapper.readValue(mvcResult.getResponse().getContentAsString(), LoginResp.class);

        assertThat(result.getToken()).isEqualTo("token");

    }

}
