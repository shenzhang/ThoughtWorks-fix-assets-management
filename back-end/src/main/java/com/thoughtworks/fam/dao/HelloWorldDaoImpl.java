package com.thoughtworks.fam.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class HelloWorldDaoImpl implements HelloWorldDao {
    @Value("${message}")
    private String message;

    @Override
    public String getMessage() {
        return message;
    }
}
