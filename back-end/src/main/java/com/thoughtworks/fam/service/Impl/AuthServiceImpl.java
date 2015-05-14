package com.thoughtworks.fam.service.Impl;

import com.thoughtworks.fam.model.User;
import com.thoughtworks.fam.service.AuthService;

public class AuthServiceImpl implements AuthService {

    private  User nullUser = new User("not exist", "not exist");

    @Override
    public User isValid(String name, String password) {
        if (name.equals("admin") && password.equals("P@ss123456")){
            return new User("jtao", "jtao@thoughtworks.com");
        }
        return nullUser;
    }

}
