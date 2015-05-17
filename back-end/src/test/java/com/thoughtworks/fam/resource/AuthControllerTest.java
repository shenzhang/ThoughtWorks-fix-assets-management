package com.thoughtworks.fam.resource;

import com.thoughtworks.fam.exception.AuthException;
import com.thoughtworks.fam.model.LoginInformation;
import com.thoughtworks.fam.service.AuthService;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
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
        String user = "user";
        String password = "passwords";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userName", user);
        jsonObject.put("password", password);

        LoginInformation responseEntity = authController.login(jsonObject);
        verify(authService).validate(user, password);
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


    private void expectErrorMessageForUserAndPassword(String errorMsg, String user, String password) throws AuthException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userName", user);
        jsonObject.put("password", password);

        given(authService.validate(eq(user),eq(password)))
                .willThrow(new AuthException(errorMsg));

        LoginInformation responseEntity = authController.login(jsonObject);
        assertThat(responseEntity.getErrorCode(), is(HttpStatus.UNAUTHORIZED));
        assertThat(responseEntity.getErrorMessage(), is(errorMsg));
    }
}