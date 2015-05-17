package com.thoughtworks.fam.dao;

public interface AuthDao {
    boolean containsUser(String user);
    boolean verifyPassword(String user, String password);
}
