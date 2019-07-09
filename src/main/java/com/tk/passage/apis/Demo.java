package com.tk.passage.apis;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {


    @RequestMapping(value = "/hello")
    public String demo(){

        return "helloworld";
    }
}
