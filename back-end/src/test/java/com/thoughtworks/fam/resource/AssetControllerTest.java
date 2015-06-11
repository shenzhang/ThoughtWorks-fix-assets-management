package com.thoughtworks.fam.resource;

import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.domain.Json.CreateAssetJson;
import com.thoughtworks.fam.exception.CreateAssetException;
import com.thoughtworks.fam.service.AssetService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
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

        Asset asset = new Asset().withAssetName("Mac Mini").withNumber("87654321");
        ResponseEntity<CreateAssetJson> responseEntity = assetController.create(asset);
        assertThat(responseEntity.getBody().getMessage(), is("success"));

    }

    @Test(expected = CreateAssetException.class)
    public void should_return_err_msg_when_asset_number_is_longer_than_8() {

        Asset asset1 = new Asset().withAssetName("Mac Mini").withNumber("87654321tw");
        when(assetService.save(asset1)).thenThrow(new CreateAssetException("Name should be made up of 8 numbers."));
        ResponseEntity<CreateAssetJson> responseEntity = assetController.create(asset1);
        assertThat(responseEntity.getBody().getMessage(), is("Name should be made up of 8 numbers."));
    }

    @Test(expected = CreateAssetException.class)
    public void should_return_err_msg_when_asset_number_is_shorter_than_8() {

        Asset asset1 = new Asset().withAssetName("Mac Mini").withNumber("tw1");
        when(assetService.save(asset1)).thenThrow(new CreateAssetException("The name already exist, please use another one."));
        ResponseEntity<CreateAssetJson> responseEntity = assetController.create(asset1);
        assertThat(responseEntity.getBody().getMessage(), is("The name already exist, please use another one."));
    }
}