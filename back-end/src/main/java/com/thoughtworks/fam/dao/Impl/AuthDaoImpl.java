package com.thoughtworks.fam.dao.Impl;

import com.thoughtworks.fam.dao.AuthDao;
import com.thoughtworks.fam.domain.User;

import java.util.Arrays;
import java.util.List;

public class AuthDaoImpl implements AuthDao {

    private List<User> userList = Arrays.asList(
            new User("ncmao"),
            new User("jtao")
    );

    @Override
    public boolean containsUser(String user) {
        return (contains(new User(user)) != null);
    }

    @Override
    public boolean verifyPassword(String username, String password) {
        User user = new User(username);
        user.setPassword(password);
        User tempUser = contains(user);
        return tempUser != null && (tempUser.getPassword().equals(user.getPassword()));
    }

    private User contains(User otherUser) {
        for (User temp : userList) {
            if (temp.equalsAnotherUser(otherUser)) {
                return temp;
            }
        }
        return null;
    }
}
