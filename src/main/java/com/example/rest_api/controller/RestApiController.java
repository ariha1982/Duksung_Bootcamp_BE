package com.example.rest_api.controller;

import com.example.rest_api.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/hello")
    public String hello(){
        return "<html><body><h1> Hello Spring Boot </h1></body></html>";
    }

    @GetMapping("/echo/{message}/{number}/{bool}")
    public String echo(@PathVariable String message, @PathVariable int number, @PathVariable boolean bool) {
        System.out.println("echo message : " + message);
        String upperMsg = message.toUpperCase();
        return  "Upper Message: " + upperMsg + " | Integer: " + number + " | Boolean: " + bool;
    }

    @GetMapping("/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued_day") String issuedDay
    ){
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }

    @GetMapping("/book2")
    public void queryParamDto(
            BookQueryParam bookQueryParam
    ){
        System.out.println(bookQueryParam);
    }

    @GetMapping("/add")
    public int add(
            @RequestParam int a,
            @RequestParam int b
    ){
        return a+b;
    }

    @GetMapping("/mul")
    public int mul(
            @RequestParam int a,
            @RequestParam int b
    ){
        return a*b;
    }

    @DeleteMapping(path = {
            "/user/{userName}/delete",
            "/user/{userName}/dsl"
    }) // path = {} 로 명시하면 여러 주소 사용 가능
    public void delete(
            @PathVariable String userName
    ){
        log.info("user-name : {}", userName);
    }
}
