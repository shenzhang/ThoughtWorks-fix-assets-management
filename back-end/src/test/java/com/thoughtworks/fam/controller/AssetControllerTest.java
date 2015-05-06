package com.thoughtworks.fam.controller;

import com.thoughtworks.fam.service.AssetService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class AssetControllerTest {
    @Mock
    AssetService assetService;

    @InjectMocks
    AssetController assetController;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void should_get_asset_list_when_give_owner_name() throws Exception {
        String ownerName = "yansiyu";
        assetController.getAssets(ownerName);
        verify(assetService).getAssetsByOwnerName("yansiyu");
    }
}