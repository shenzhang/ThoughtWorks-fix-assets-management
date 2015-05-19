package com.thoughtworks.fam.resource;

import com.thoughtworks.fam.domain.LoginInformation;
import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.exception.AuthException;
import com.thoughtworks.fam.service.AuthService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

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
    public void should_raise_error_if_username_is_not_exist() throws Exception {
        String errorMsg = "User doesn't exist";

        String notExistsUser = "notExistsUser";
        String password = "password";

        expectErrorMessageForUserAndPassword(errorMsg, notExistsUser, password);
    }

    @Test
    public void should_be_able_login_when_given_right_user_and_password() throws AuthException {
        User user = new User("name", "password");

        LoginInformation responseEntity = authController.login(user);
        given(authService.validate(user.getName(), user.getPassword()))
                .willReturn(true);
        assertThat(responseEntity.getErrorCode(), is(HttpStatus.OK));
        assertThat(responseEntity.getErrorMessage(), is("Success!"));
    }

    @Test
    public void should_raise_error_if_password_is_not_right() throws Exception {
        String errorMsg = "password is not correct";

        String user = "user";
        String wrongPassword = "pass";

        expectErrorMessageForUserAndPassword(errorMsg, user, wrongPassword);

    }


    private void expectErrorMessageForUserAndPassword(String errorMsg, String name, String password) throws AuthException {
        User user = new User(name, password);

        given(authService.validate(user.getName(),user.getPassword()))
                .willThrow(new AuthException(errorMsg));

        LoginInformation responseEntity = authController.login(user);
        assertThat(responseEntity.getErrorCode(), is(HttpStatus.UNAUTHORIZED));
        assertThat(responseEntity.getErrorMessage(), is(errorMsg));
    }
}