package com.thoughtworks.fam.resource;

import com.thoughtworks.fam.domain.JSONObject;
import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.exception.AuthException;
import com.thoughtworks.fam.service.AuthService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

public class AuthControllerTest {
    @InjectMocks
    private AuthController authController;
    @Mock
    private AuthService authService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void should_throw_auth_exception_if_username_is_not_exist() {
        String name = "notExistsUser";
        String password = "password";
        given(authService.validate(name, password))
                .willReturn(name);

        try {
            authController.login(new User(name, password));
        } catch (AuthException err) {
            assertThat(err.getMessage(), is("The user is not exist."));
        }
    }

    @Test
    public void should_be_able_login_when_given_right_user_and_password() throws AuthException {
        String name = "ncmao";
        String password = "P@ss123456";
        given(authService.validate(name, password))
                .willReturn("success");
        JSONObject jsonObject = authController.login(new User(name, password));
        assertThat(jsonObject.getMessage(), is("Success!"));
    }

    @Test
    public void should_throw_auth_exception_if_password_is_not_right() {
        String name = "ncmao";
        String password = "password";
        given(authService.validate(name, password))
                .willReturn(password);

        try {
            authController.login(new User(name, password));
        } catch (AuthException err) {
            assertThat(err.getMessage(), is("The password is not correct, please input again."));
        }

    }

}