package com.mooc.house.controller;

import com.mooc.house.common.RestResponse;
import com.mooc.house.config.GenericRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private GenericRest genericRest;

    @GetMapping("/getUserName")
    public  RestResponse getUserName(long id){
        String url = "http://user-service/getUserName?id="+id;
        RestResponse<String> body = genericRest.get(url, new ParameterizedTypeReference<RestResponse<String>>() {
        }).getBody();
        return body;
    }
}
