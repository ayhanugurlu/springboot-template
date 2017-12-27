package com.au.example.rest.mapper;

import com.au.example.dto.LoginInputDTO;
import com.au.example.dto.LoginOutputDTO;
import com.au.example.rest.model.req.LoginReq;
import com.au.example.rest.model.resp.LoginResp;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

/**
 * Created by Ayhan Ugurlu - (ayhan.ugurlu@odc.com.tr) on 13.09.2017.
 */
@Component
public class LoginControllerMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {
        factory.classMap(LoginInputDTO.class, LoginReq.class)
                .byDefault()
                .register();

        factory.classMap(LoginResp.class, LoginOutputDTO.class)
                .byDefault()
                .register();
    }


}

