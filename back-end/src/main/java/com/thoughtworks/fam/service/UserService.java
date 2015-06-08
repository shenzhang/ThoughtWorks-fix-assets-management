package com.thoughtworks.fam.service;

import com.thoughtworks.fam.domain.User;

public interface UserService {

    User save(String name);

    User updatePassword(User user);

}
