package com.thoughtworks.fam.service;


public interface AuthService {

    boolean validate(String user, String password);
}
