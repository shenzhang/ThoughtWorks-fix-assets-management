package com.thoughtworks.fam;

import com.thoughtworks.fam.controller.UserController;
import com.thoughtworks.fam.model.Asset;
import com.thoughtworks.fam.service.AssetService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerIntegrationTest {

    @Mock
    private AssetService assetService;

    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void should_get_asset_success() throws Exception {
        List<Asset> assets = Arrays.asList(new Asset().withAssetName("macbook").withAssignedDate("2015-05-09")
                .withNumber("123456").withType("laptop"));
        given(assetService.findAssetsByUserName("user1")).willReturn(assets);
        this.mockMvc.perform(get("/user/user1/assets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].assetName", is("macbook")))
                .andExpect(jsonPath("$[0].type", is("laptop")))
                .andExpect(jsonPath("$[0].assignDate", is("2015-05-09")))
                .andExpect(jsonPath("$[0].number", is("123456")));
    }

    @Test
    public void should_get_asset_json_object() throws Exception {
        this.mockMvc.perform(get("/user/allassets"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"data\":[]}"));
    }

    @Test
    public void should_create_user_success() throws Exception {
        given(assetService.createUser("jtao@thoughtworks.com")).willReturn(true);
        this.mockMvc.perform(post("/user/create").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("email", "jtao@thoughtworks.com"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    public void should_create_user_failed() throws Exception {
        given(assetService.createUser("jtao1@thoughtworks.com")).willReturn(false);
        this.mockMvc.perform(post("/user/create").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("email", "jtao1@thoughtworks.com"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));

    }

    @Test
    public void should_login_user_success() throws Exception {
        given(assetService.isValid("admin", "P@ss123456")).willReturn(true);
        this.mockMvc.perform(post("/user/login").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("userName", "admin")
                .param("password", "P@ss123456"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

    }

    @Test
    public void should_login_failed() throws Exception {
        given(assetService.isValid("admin", "123456")).willReturn(false);
        this.mockMvc.perform(post("/user/login").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("userName", "admin")
                .param("password", "P@ss123456"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }
}
