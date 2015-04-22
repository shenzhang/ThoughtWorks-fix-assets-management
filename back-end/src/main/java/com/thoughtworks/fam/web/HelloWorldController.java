package com.thoughtworks.fam.web;

import com.thoughtworks.fam.web.dto.HelloWorldDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/helloworld")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET)
    public HelloWorldDTO say() {
        HelloWorldDTO dto = new HelloWorldDTO();
        dto.setMessage("Hello World");
        return dto;
    }
}
