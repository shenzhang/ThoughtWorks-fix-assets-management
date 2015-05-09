package com.thoughtworks.fam.controller;

import com.thoughtworks.fam.service.AssetService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AssetControllerTest {
    @Mock
    private AssetService assetService;

    @InjectMocks
    private AssetController assetController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(assetController).build();
    }

    @Test
    public void should_get_my_asset_list_when_give_owner_name() throws Exception {
        String ownerName = "yansiyu";
        assetController.getAssets(ownerName);
        verify(assetService).getAssetsByOwnerName("yansiyu");

        this.mockMvc.perform(get("/asset/my/whatever"))
                .andExpect(status().isOk());


        this.mockMvc.perform(get("/asset2/my/{id}", ownerName))
                .andExpect(status().isNotFound());

    }
    @Test
    public void should_get_other_asset_list_when_give_owner_name() throws Exception {
        String ownerName = "yansiyu";
        assetController.getOtherAssets(ownerName);
        verify(assetService).getAssetsExceptOwner(ownerName);

        this.mockMvc.perform(get("/asset/other/whatever"))
                .andExpect(status().isOk());


        this.mockMvc.perform(get("/asset2/other/{id}", ownerName))
                .andExpect(status().isNotFound());

    }

}