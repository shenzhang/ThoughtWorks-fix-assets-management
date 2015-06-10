package com.thoughtworks.fam.service.Impl;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.exception.AuthException;
import com.thoughtworks.fam.exception.CreateUserException;
import com.thoughtworks.fam.repository.UserRepository;
import com.thoughtworks.fam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    public static String EMAIL_SUFFIX = "@thoughtworks.com";

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(String name) {
        if (userRepository.findUserByName(name) != null) {
            throw new CreateUserException("user already exist");
        }
        if (!isValidFor(name)) {
            throw new CreateUserException("user name is invalid");
        }
        return userRepository.save(new User(name, name + EMAIL_SUFFIX));
    }

    @Override
    public User updatePassword(User user) {

        if (userRepository.findUserByName(user.getName()) == null) {
            throw new AuthException("User is invalid!");
        }
        if (user.getPassword().length() < 8) {
            throw new AuthException("Passwords should be 8 or more characters in length.");
        }
        return userRepository.save(user);
    }

    private boolean isValidFor(final String userName) {

        for (String name : allValidUserNames()) {
            if (name.equals(userName)) {
                return true;
            }
        }
        return false;
    }


    private List<String> allValidUserNames() {
        List<User> users = (List<User>) userRepository.findAll();
        return FluentIterable.from(users).transform(new Function<User, String>() {
            @Override
            public String apply(User user) {
                return user.getName();
            }
        }).toList();

    }
}
