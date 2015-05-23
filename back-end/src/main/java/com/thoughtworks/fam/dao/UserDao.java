package com.thoughtworks.fam.dao;

import com.thoughtworks.fam.domain.User;

import java.util.List;

public interface UserDao {


    User save(User user);

    List<User> findAllUsers();

    User findUserByName(String name);

    List<String> validUserNames();

    User modifyPassword(User user);

}
