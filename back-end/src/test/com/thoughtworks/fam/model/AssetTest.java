package com.thoughtworks.fam.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssetTest {
    @Test
    public void should_give_an_asset_data() {

        Asset asset = new Asset("Nokia", "17006011", "2014-04-20", "Mobile","yansiyu");

        assertEquals("Nokia", asset.getassetName());
        assertEquals("17006011", asset.getNumber());
        assertEquals("2014-04-20", asset.getAssignedDate());
        assertEquals("Mobile", asset.getType());

    }

}