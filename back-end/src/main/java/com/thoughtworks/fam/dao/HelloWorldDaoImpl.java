package com.thoughtworks.fam.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * User: Zhang Shen
 * Date: 4/25/15
 * Time: 10:29 AM
 */
@Repository
public class HelloWorldDaoImpl implements HelloWorldDao {
    @Value("${message}")
    private String message;

    @Override
    public String getMessage() {
        return message;
    }
}
