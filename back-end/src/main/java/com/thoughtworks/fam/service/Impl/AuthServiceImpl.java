package com.thoughtworks.fam.service.Impl;

import com.thoughtworks.fam.dao.AuthDao;
import com.thoughtworks.fam.dao.Impl.AuthDaoImpl;
import com.thoughtworks.fam.exception.AuthException;
import com.thoughtworks.fam.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

//    @Autowired
//    private AuthDao authDao;

    private AuthDao authDao = new AuthDaoImpl();

    @Override
    public boolean validate(String user, String password) {
        if (authDao.containsUser(user)) {
            if (authDao.verifyPassword(user, password)) {
                return true;
            }
            throw new AuthException("The password is not correct, please input again.");

        }
        throw new AuthException("The user is not exist.");
    }

}
