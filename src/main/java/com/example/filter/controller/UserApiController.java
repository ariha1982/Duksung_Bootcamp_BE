package com.example.filter.controller;

import com.example.filter.interceptor.OpenApi;
import com.example.filter.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

// @OpenApi <- 이걸 여기다 붙이면 이 안의 모든 경로는 Open Api임
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @OpenApi
    @PostMapping("")
    public Object register(
        @RequestBody UserRequest userRequest
    ) {
        log.info("{}", userRequest);
        return userRequest;
    }

    @GetMapping("/hello")
    public void hello(){
        log.info("hello");
    }
}
