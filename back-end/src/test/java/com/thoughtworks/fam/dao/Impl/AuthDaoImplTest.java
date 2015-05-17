package com.thoughtworks.fam.dao.Impl;

import com.thoughtworks.fam.dao.AuthDao;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthDaoImplTest {

    @Test
    public void should_return_false_when_user_is_not_exist() {
        String user = "user";
        AuthDao authDao = new AuthDaoImpl();

        assertEquals(authDao.containsUser(user), false);
    }

    @Test
    public void should_return_true_when_user_is_exist() {
        String user = "jtao";
        AuthDao authDao = new AuthDaoImpl();

        assertEquals(authDao.containsUser(user), true);
    }

    @Test
    public void should_return_false_when_password_is_not_correct() {
        String user = "jtao";
        String wrongPassword = "password";
        AuthDao authDao = new AuthDaoImpl();

        assertEquals(authDao.verifyPassword(user, wrongPassword), false);
    }

    @Test
    public void should_return_true_when_password_is_correct() {
        String user = "jtao";
        String rightPassword = "P@ss123456";
        AuthDao authDao = new AuthDaoImpl();

        assertEquals(authDao.verifyPassword(user, rightPassword), true);
    }
}