package com.thoughtworks.fam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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


    private User user;

    private String jsonUser;
    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() throws JsonProcessingException {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        user = new User("siyu", "siyu@thoughtworks.com");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        jsonUser = ow.writeValueAsString(user);
    }


    @Test
    public void should_create_user_success() throws Exception {

        given(userService.save("siyu"))
                .willReturn(user);
        this.mockMvc.perform(post("/users/create").contentType(MediaType.APPLICATION_JSON)
                .content(jsonUser))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message", is("create success")));
    }

    @Test
    public void should_create_user_failed() throws Exception {
        given(userService.save("siyu"))
                .willReturn(null);
        this.mockMvc.perform(post("/users/create").contentType(MediaType.APPLICATION_JSON)
                .content(jsonUser))
                .andExpect(status().isForbidden());
    }
}
