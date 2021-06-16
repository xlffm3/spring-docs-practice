package com.example.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/dispatcher")
    public String testDispatcherServlet() {
        return "jinhong " + helloService.getHelloName();
    }
}
