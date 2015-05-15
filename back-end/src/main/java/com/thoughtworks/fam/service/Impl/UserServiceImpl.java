package com.thoughtworks.fam.service.Impl;

import com.thoughtworks.fam.dao.UserDao;
import com.thoughtworks.fam.model.User;
import com.thoughtworks.fam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    public static String EMAIL_SUFFIX = "@thoughtworks.com";

    @Autowired
    private UserDao userDao;

    @Override
    public User save(String name) {
        if (userDao.findUserByName(name) !=null) {
            throw new RuntimeException("user is exist");
        }
        if (!isValidFor(name)) {
            throw new RuntimeException("user name is invalid");
        }
        return userDao.save(new User(name, name + EMAIL_SUFFIX));
    }

    private boolean isValidFor(final String userName) {
        List<String> userNames = userDao.validUserNames();

        for (String name : userNames) {
            if (name.equals(userName)) {
                return true;
            }
        }
        return false;
    }
}
