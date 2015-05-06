package com.thoughtworks.fam.controller;

import com.thoughtworks.fam.service.AssetService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/*public class AssetController*{/Test
    /*  private AssetController assetController;
    //  private AssetService assetService;
      private MockMvc mockMvc;
      private AssetService mockassetservice;
      @Before
      public void setup() {
          this.mockMvc = MockMvcBuilders.standaloneSetup(assetService)
                  .build();

          mockdao = mock(AssetService.class);
          ass
  }

     *//* @Test
    public void testFindPageUsers() throws Exception {
        ra = this.mockMvc.perform(MockMvcRequestBuilders);

    }*/
/*
    private @InjectMocks
    AssetController assetController;
    private @Mock
    AssetService mockassetService;
    @Before
    public void setup() throws Exception {
       mockassetService=mock(AssetService.class);
        assetController.say("yansiyu");
        MockitoAnnotations.initMocks(this);


    }
*/

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration

class ControllerTests {

    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void controllerExceptionHandler() throws Exception {
        this.mockMvc.perform(get("/test"))
                .andExpect(status().isOk());
    }


}