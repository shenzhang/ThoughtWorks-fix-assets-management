package com.thoughtworks.fam.controller;

import com.thoughtworks.fam.service.AuthService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class AuthControllerTest {
    @InjectMocks
    private AuthController authController;
    @Mock
    private AuthService authService;

    @Test
    public void should_call_validate_and_return_json_body_when_login() {
        initMocks(this);
        String user = "user";
        String password = "password";
        authController.login(user, password);
        verify(authService).validate(user, password);
    }
}