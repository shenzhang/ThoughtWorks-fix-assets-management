package com.thoughtworks.fam.dao.Impl;

import com.thoughtworks.fam.dao.UserDao;
import com.thoughtworks.fam.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDaoImpl implements UserDao {

    private Map<String, User> allUsers =
            new HashMap<String, User>(){{
                put("ncmao", new User("ncmao", "ncmao@thoughtworks.com"));
                put("jtao", new User("jtao", "jtao@thoughtworks.com"));
            }};
    private List<String> validUserName = Arrays.asList("ncmao", "jtao", "siyu");

    @Override
    public User save(User user) {
        allUsers.put(user.getName(), user);
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        return new ArrayList<User>(allUsers.values());
    }

    @Override
    public User findUserByName(String name) {
        return allUsers.get(name);
    }

    @Override
    public List<String> validUserNames() {
        return validUserName;
    }

}
