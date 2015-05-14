package com.thoughtworks.fam.service;

import com.thoughtworks.fam.model.User;

public interface AuthService {

    User isValid(String name, String password);

}
