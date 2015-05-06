package com.thoughtworks.fam.service;

import com.thoughtworks.fam.dao.AssetDao;
import com.thoughtworks.fam.model.Asset;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AssetServiceImplTest {
    @Mock
    AssetDao assetDao;
    @InjectMocks
    AssetServiceImpl assetService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        List<Asset> assets = Arrays.asList(
                new Asset("Nokia", "17006011", "2014-04-20", "Mobile", "yansiyu"),
                new Asset("MBP", "17005800", "2014-04-28", "lap top", "yansiyu"),
                new Asset("Screen", "17006036", "2014-06-16", "Others", "yansiyu")
        );
        when(assetDao.getAssets("yansiyu")).thenReturn(assets);
    }

    @Test
    public void should_get_asset_list_when_give_owner_name() throws Exception {
        String ownerName = "yansiyu";
        assetService.getAssetsByOwnerName(ownerName);
        verify(assetDao).getAssets(ownerName);
        assertEquals("MBP", assetDao.getAssets(ownerName).get(0).getAssetName());
    }


}