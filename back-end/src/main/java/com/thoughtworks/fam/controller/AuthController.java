package com.thoughtworks.fam.controller;


import com.thoughtworks.fam.service.AuthService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private AuthService authService;


    @RequestMapping(value = "/login", method = POST)
    public ResponseEntity<JSONObject> login(@RequestParam String user, @RequestParam String password) {

        JSONObject result = authService.validate(user, password);
        return new ResponseEntity<JSONObject>(result, HttpStatus.OK);
    }
}
