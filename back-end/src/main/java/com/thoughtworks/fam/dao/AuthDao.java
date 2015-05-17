package com.thoughtworks.fam.dao;

public interface AuthDao {
    public boolean containsUser(String user);
    public boolean verifyPassword(String user, String password);
}
