package com.example.rest_api.controller;

import com.example.rest_api.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put")
    public void put(
            @RequestBody UserRequest userRequest
    ){
        // 그냥 print하면 많이 했을 때 속도가 느려짐 반면 log는 자체 버퍼가 있어서 프로그램 속도에 영향이 없음
        log.info("Request : {}", userRequest);
    }
}
