package com.thoughtworks.fam.dao.Impl;

import com.thoughtworks.fam.dao.UserDao;
import com.thoughtworks.fam.model.User;

public class UserDaoImpl implements UserDao {


    @Override
    public User save(User user) {
        return user;
    }
}
