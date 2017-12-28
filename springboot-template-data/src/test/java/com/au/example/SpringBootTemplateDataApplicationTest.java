package com.au.example;

import com.au.example.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTemplateDataApplicationTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void contextLoads() {
        Assertions.assertThat(userRepository).isNotNull();
    }
}
