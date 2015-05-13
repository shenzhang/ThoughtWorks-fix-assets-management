package com.thoughtworks.fam;

import com.thoughtworks.fam.dao.Impl.UserDaoImpl;
import com.thoughtworks.fam.dao.UserDao;
import com.thoughtworks.fam.service.AuthService;
import com.thoughtworks.fam.service.Impl.AuthServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class Application {
    @Bean
    public AuthService authService() {
        return new AuthServiceImpl();
    }

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
