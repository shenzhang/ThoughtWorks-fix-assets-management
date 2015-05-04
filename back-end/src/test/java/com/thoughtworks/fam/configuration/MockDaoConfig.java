package com.thoughtworks.fam.configuration;

import com.thoughtworks.fam.dao.HelloWorldDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.mock;

/**
 * User: Zhang Shen
 * Date: 5/4/15
 * Time: 7:41 PM
 */
@Profile("stub")
@Configuration
public class MockDaoConfig {
    @Bean
    public HelloWorldDao helloWorldDao() {
        return mock(HelloWorldDao.class);
    }
}
