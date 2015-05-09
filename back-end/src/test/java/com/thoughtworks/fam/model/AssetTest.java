package com.thoughtworks.fam.model;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class AssetTest {

    @Test
    public void should_get_asset_data_when_have_initialise() throws Exception {
        Asset asset = new Asset("Nokia", "17006011", "2014-04-20", "Mobile", "yansiyu");
        assertEquals("Nokia", asset.getAssetName());
        assertEquals("17006011", asset.getNumber());
        assertEquals("2014-04-20", asset.getAssignDate());
        assertEquals("Mobile", asset.getType());
        assertEquals("yansiyu", asset.getOwnerName());
    }

}