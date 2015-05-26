package com.thoughtworks.fam.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.domain.Json.CreateUserJson;
import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.exception.AuthException;
import com.thoughtworks.fam.service.AssetService;
import com.thoughtworks.fam.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest {

    private static final List<Asset> ASSETS = Arrays.asList(new Asset());
    public static final String PASSWORD_MODIFY_ERROR_MESSAGE = "Passwords should be 8 or more characters in length.";
    public static final String PASSWORD_MODIFY_SUCCESS_MESSAGE = "Password is modified!";

    private User user;

    private String jsonUser;
    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    @Mock
    private AssetService assetService;

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


    @Test
    public void should_return_allAssets() throws Exception {
        given(assetService.findAll()).willReturn(ASSETS);
        ResponseEntity<List<Asset>> assets = userController.getAllAssets();
        verify(assetService).findAll();
        assertThat(assets.getBody(), is(ASSETS));
    }
    @Test
    public void should_return_assetsByUsername() throws Exception {
        given(assetService.findAssetsByUserName("jtao")).willReturn(ASSETS);
        ResponseEntity<List<Asset>> assets = userController.getAssets("jtao");
        verify(assetService).findAssetsByUserName("jtao");
        assertThat(assets.getBody(), is(ASSETS));
    }

    @Test
    public void should_return_ok_when_password_is_modified() throws Exception {
        user.setPassword("123456789");
        given(userService.modifyPassword(user)).willReturn(user);

        ResponseEntity<CreateUserJson> responseEntity = userController.modifyPassword(user);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        assertThat(responseEntity.getBody().getMessage(), is(PASSWORD_MODIFY_SUCCESS_MESSAGE));
    }

    @Test
    public void should_return_not_modified_when_password_is_less_than_eight() throws Exception {
        user.setPassword("123");
        given(userService.modifyPassword(user)).willThrow(new AuthException(PASSWORD_MODIFY_ERROR_MESSAGE));

        ResponseEntity<CreateUserJson> responseEntity = userController.modifyPassword(user);

        assertThat(responseEntity.getBody().getMessage(), is(PASSWORD_MODIFY_ERROR_MESSAGE));
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    }
}
