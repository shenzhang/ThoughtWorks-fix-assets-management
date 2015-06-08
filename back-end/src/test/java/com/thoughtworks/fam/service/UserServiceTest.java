package com.thoughtworks.fam.service;

import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.exception.AuthException;
import com.thoughtworks.fam.exception.CreateUserException;
import com.thoughtworks.fam.repository.UserRepository;
import com.thoughtworks.fam.service.Impl.UserServiceImpl;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {


    public List<User> mockUsers =
            Arrays.asList(new User("ncmao","12345678"),new User("jtao","12345678"),
                    new User("siyu","12345678"),new User("lq","12345678")
            );
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;


    @Test
    public void should_create_user_success_when_input_valid_user_name(){
        given(userRepository.findUserByName("lq")).willReturn(null);
        given(userRepository.findAll()).willReturn(mockUsers);
        given(userRepository.save(any(User.class))).willReturn(new User("lq", "lq@thoughtworks.com"));

        User lq = userService.save("lq");

        assertThat(lq.getName(), is("lq"));
    }

    @Test(expected = CreateUserException.class)
    public void should_create_user_failed_when_user_has_existed(){
        given(userRepository.findUserByName("ncmao")).willReturn(new User("ncmao","ncmao@thoughtworks.com"));
        userService.save("ncmao");
    }

    @Test(expected = CreateUserException.class)
    public void should_create_user_failed_when_userName_inValid(){
        given(userRepository.findUserByName("jtao1")).willReturn(null);
        given(userRepository.findAll()).willReturn(mockUsers);
        userService.save("jtao1");
    }

    @Test
    public void should_return_modify_failed_when_password_length_is_less_then_eight() {
        String errorMsg = "Passwords should be 8 or more characters in length.";
        User newUser = new User("siyu");
        String wrongPassword = "123";
        newUser.setPassword(wrongPassword);

        given(userRepository.findUserByName(newUser.getName())).willReturn(newUser);

        try {
            userService.updatePassword(newUser);
            fail("Password is modified!");
        } catch (AuthException e) {
            assertThat(e.getMessage(), Matchers.is(errorMsg));
        }


    }
}
