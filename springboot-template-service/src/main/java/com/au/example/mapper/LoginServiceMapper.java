package com.au.example.mapper;

import com.au.example.dto.*;
import com.au.example.entity.User;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {
        factory.classMap(User.class, CreateUserInputDTO.class)
                .byDefault()
                .register();

        factory.classMap(CreateUserOutputDTO.class, User.class)
                .byDefault()
                .register();


        factory.classMap(UserDTO.class, User.class)
                .byDefault()
                .register();

    }
}
