package com.thoughtworks.fam.service.Impl;

import com.thoughtworks.fam.dao.UserDao;
import com.thoughtworks.fam.model.User;
import com.thoughtworks.fam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    public static String EMAIL_SUFFIX = "@thoughtworks.com";

    @Autowired
    private UserDao userDao;

    @Override
    public User save(String name) {
        return userDao.save(new User(name, name + EMAIL_SUFFIX));
    }
}
