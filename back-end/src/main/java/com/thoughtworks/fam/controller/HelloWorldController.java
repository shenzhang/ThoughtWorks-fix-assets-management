package com.thoughtworks.fam.controller;

import com.thoughtworks.fam.service.HelloWorldService;
import com.thoughtworks.fam.model.HelloWorldDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/helloworld")
public class HelloWorldController {
    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping(method = RequestMethod.GET)
    public HelloWorldDTO say() {
        HelloWorldDTO asset = new HelloWorldDTO();
        asset.setMessage(helloWorldService.getMessage());
        return asset;
    }
}
