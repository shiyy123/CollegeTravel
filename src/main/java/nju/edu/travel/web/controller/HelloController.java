package nju.edu.travel.web.controller;

import nju.edu.travel.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "say")
public class HelloController {
    @Autowired
    private HelloService helloService;

    @GetMapping("hello")
    public String hello() {
        return helloService.sayHello();
    }
}
