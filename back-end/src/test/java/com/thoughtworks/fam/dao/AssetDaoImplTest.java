package com.thoughtworks.fam.dao;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssetDaoImplTest {

    AssetDaoImpl assetDao = new AssetDaoImpl();

    @Test
    public void should_get_asset_list_when_give_owner_name() throws Exception {

        assertEquals("Nokia", assetDao.getAssets("yansiyu").get(0).getAssetName());
        assertEquals("MBP", assetDao.getAssets("yansiyu").get(1).getAssetName());
        assertEquals("Screen", assetDao.getAssets("yansiyu").get(2).getAssetName());
        assertEquals(3, assetDao.getAssets("yansiyu").size());
    }
}