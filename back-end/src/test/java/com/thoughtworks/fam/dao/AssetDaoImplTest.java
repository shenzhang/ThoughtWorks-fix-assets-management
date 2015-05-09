package com.thoughtworks.fam.dao;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssetDaoImplTest {

    AssetDaoImpl assetDao = new AssetDaoImpl();

    @Test
    public void should_get_my_asset_list_when_give_owner_name() throws Exception {

        assertEquals("Nokia", assetDao.getAssets("yansiyu").get(0).getAssetName());
        assertEquals("yansiyu", assetDao.getAssets("yansiyu").get(0).getOwnerName());
        assertEquals("MBP", assetDao.getAssets("yansiyu").get(1).getAssetName());
        assertEquals("Screen", assetDao.getAssets("yansiyu").get(2).getAssetName());
        assertEquals(3, assetDao.getAssets("yansiyu").size());
    }

    @Test
    public void should_get_other_asset_list_when_give_except_owner_name() throws Exception {

        assertEquals("lvjing", assetDao.getOthersAssets("yansiyu").get(0).getOwnerName());

    }
}