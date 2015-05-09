package com.thoughtworks.fam.service;

import com.thoughtworks.fam.dao.HelloWorldDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    @Autowired
    private HelloWorldDao helloWorldDao;

    @Override
    public String getMessage() {
        return helloWorldDao.getMessage();
    }
}
