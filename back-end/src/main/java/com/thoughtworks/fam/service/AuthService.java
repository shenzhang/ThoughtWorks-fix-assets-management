package com.thoughtworks.fam.service;


import com.thoughtworks.fam.exception.AuthException;

public interface AuthService {

    public boolean validate(String user, String password) throws AuthException;
}
