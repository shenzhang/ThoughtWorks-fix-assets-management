package com.thoughtworks.fam.resource;

import com.thoughtworks.fam.domain.Json.CreateAssetJson;
import com.thoughtworks.fam.domain.NewAsset;
import com.thoughtworks.fam.service.AssetService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

public class AssetControllerTest {
    @InjectMocks
    private AssetController assetController;

    @Mock
    private AssetService assetService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }
    @Test
    public void should_return_success_when_asset_serial_name_is_validate() throws Exception {

        NewAsset newAsset = new NewAsset("Mac Mini", "87654321");

        ResponseEntity<CreateAssetJson> newAssetJson = assetController.create(newAsset);

        assertThat(newAssetJson.getBody().getMessage(), is("success"));

    }
    @Test
    public void should_return_err_msg_when_asset_serial_name_is_not_validate() throws Exception {

        NewAsset newAsset = new NewAsset("Mac Mini", "87654321tw");
        NewAsset newAsset2 = new NewAsset("Mac Mini", "876");

        ResponseEntity<CreateAssetJson> newAssetJson = assetController.create(newAsset);
        ResponseEntity<CreateAssetJson> newAssetJson2 = assetController.create(newAsset2);
        assertThat(newAssetJson.getBody().getMessage(), is("Name should be made up of 8 numbers."));
        assertThat(newAssetJson2.getBody().getMessage(), is("Name should be made up of 8 numbers."));
    }
}