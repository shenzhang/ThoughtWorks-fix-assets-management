package com.thoughtworks.fam.service.Impl;

import com.thoughtworks.fam.dao.AuthDao;
import com.thoughtworks.fam.dao.Impl.AuthDaoImpl;
import com.thoughtworks.fam.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

//    @Autowired
//    private AuthDao authDao;

    private AuthDao authDao = new AuthDaoImpl();

    @Override
    public String validate(String name, String password) {
        if (!authDao.containsUser(name)) {
            return name;
        }
        if (!authDao.verifyPassword(name, password)) {
            return password;
        }
        return "success";
    }

}
