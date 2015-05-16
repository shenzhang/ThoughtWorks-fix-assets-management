package com.thoughtworks.fam.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.thoughtworks.fam.model.Asset;
import com.thoughtworks.fam.model.User;
import com.thoughtworks.fam.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.ParseException;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest {


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

        user = new User("siyu", "siyu@thoughtworks.com", "p@ss123456");
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
                .andExpect(jsonPath("$.message", is("create user success")));
    }

    @Test
    public void should_create_user_failed() throws Exception {
        given(userService.save("siyu"))
                .willReturn(null);
        this.mockMvc.perform(post("/users/create").contentType(MediaType.APPLICATION_JSON)
                .content(jsonUser))
                .andExpect(status().isConflict());
    }

    @Test
    public void should_handle_username_is_null() throws ParseException {
        ResponseEntity<List<Asset>> assets = new UserController().getAssets(null);
        assertNull(assets);
    }

    @Test
    public void should_handle_username_is_empty_string() throws ParseException {
        ResponseEntity<List<Asset>> assets = new UserController().getAssets("");
        assertNull(assets);
    }

}
