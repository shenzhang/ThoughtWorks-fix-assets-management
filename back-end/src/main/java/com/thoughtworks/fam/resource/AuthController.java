package com.thoughtworks.fam.resource;


import com.thoughtworks.fam.domain.LoginInformation;
import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.exception.AuthException;
import com.thoughtworks.fam.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private AuthService authService;


    @RequestMapping(value = "/login", method = POST)
    public LoginInformation login(@RequestBody User user) {

        LoginInformation loginInformation = new LoginInformation();

        try {
            authService.validate(user.getName(), user.getPassword());
            loginInformation.setErrorCode(HttpStatus.OK);
            loginInformation.setErrorMessage("Success!");
        } catch (AuthException e) {
            loginInformation.setErrorCode(HttpStatus.UNAUTHORIZED);
            loginInformation.setErrorMessage(e.getMessage());
        }

        return loginInformation;
    }
}
