package com.publicissapient.movieticketbooking.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RequestMapping("/api/hello")
@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello(){
        return  "Hello!";
    }

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name){
        return  "Hello "+name+"!";
    }

}
