package com.au.example;

import com.au.example.rest.controller.LoginController;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SpringBootTemplateWebApplication.class)
public class SpringBootTemplateWebApplicationTest {

    @Autowired
    LoginController loginController;

    @Test
    public void contextLoads() {
        Assertions.assertThat(loginController).isNotNull();
    }

}
