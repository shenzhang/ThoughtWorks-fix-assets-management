package com.thoughtworks.fam.service.Impl;

import com.thoughtworks.fam.dao.AuthDao;
import com.thoughtworks.fam.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthDao authDao;

    @Override
    public String validate(String name, String password) {
        if (!authDao.containsUser(name)) {
            return name;
        }
        if (!authDao.verifyPassword(name, password)) {
            return password;
        }
        return "success";
    }

}
