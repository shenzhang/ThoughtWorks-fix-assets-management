package com.thoughtworks.fam.service;

import com.thoughtworks.fam.dao.HelloWorldDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Zhang Shen
 * Date: 4/25/15
 * Time: 10:28 AM
 */
@Service
public class HelloWorldServiceImpl1 implements HelloWorldService {
    @Autowired
    private HelloWorldDao helloWorldDao;

    @Override
    public String getMessage() {
        return helloWorldDao.getMessage();
    }
}
