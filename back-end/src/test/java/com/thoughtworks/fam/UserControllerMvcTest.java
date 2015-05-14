package com.thoughtworks.fam;

import com.thoughtworks.fam.controller.UserController;
import com.thoughtworks.fam.model.User;
import com.thoughtworks.fam.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerMvcTest {


    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }


    @Test
    public void should_create_user_success() throws Exception {
        given(userService.save("jtao"))
                .willReturn(new User("jtao", "jtao@thoughtworks.com"));
        this.mockMvc.perform(post("/users/create").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("userName", "jtao"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("jtao")));
    }
}
