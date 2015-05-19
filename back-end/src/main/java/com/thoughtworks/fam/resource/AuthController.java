package com.thoughtworks.fam.resource;


import com.thoughtworks.fam.domain.JSONObject;
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
    public JSONObject login(@RequestBody User user) {
        String validateResult = authService.validate(user.getName(), user.getPassword());

        if (validateResult.equals(user.getName())) {
            throw new AuthException("The user is not exist.");
        }
        if (validateResult.equals(user.getPassword())) {
            throw new AuthException("The password is not correct, please input again.");
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.setStatusCode(HttpStatus.OK);
        jsonObject.setMessage("Success!");
        return jsonObject;
    }
}
