package com.mooc.house.controller;

import com.mooc.house.common.RestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/getUserName")
    public RestResponse<String> getUserName(long id){

        return RestResponse.success("user-test"+"---"+id);
    }
}
