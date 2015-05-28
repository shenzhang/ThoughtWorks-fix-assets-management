package com.thoughtworks.fam.resource;

import com.thoughtworks.fam.domain.Json.CreateAssetJson;
import com.thoughtworks.fam.domain.NewAsset;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AssetControllerTest {
    @Test
    public void should_return_success_when_asset_serial_name_is_validate() throws Exception {
        //given
        NewAsset newAsset = new NewAsset("Mac Mini", "87654321");

        AssetController assetController = new AssetController();
        ResponseEntity<CreateAssetJson> newAssetJson = assetController.create(newAsset);

        assertThat(newAssetJson.getBody().getMessage(), is("success"));

    }
}