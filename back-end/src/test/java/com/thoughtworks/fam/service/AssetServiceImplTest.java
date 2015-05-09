package com.thoughtworks.fam.service;

import com.thoughtworks.fam.dao.AssetDao;
import com.thoughtworks.fam.model.Asset;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class AssetServiceImplTest {
    @Mock
    AssetDao assetDao;
    @InjectMocks
    AssetServiceImpl assetService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void should_get_my_sorted_asset_list_when_give_owner_name() throws Exception {
        List<Asset> assets = Arrays.asList(
                new Asset("Nokia", "17006011", "2014-04-20", "Mobile", "yansiyu"),
                new Asset("MBP", "17005800", "2014-04-28", "lap top", "yansiyu"),
                new Asset("Screen", "17006036", "2014-06-16", "Others", "lvjing")
        );
        when(assetDao.getAssets("yansiyu")).thenReturn(assets);

        String ownerName = "yansiyu";
        assetService.getAssetsByOwnerName(ownerName);
        verify(assetDao, only()).getAssets(ownerName);
        assertThat(assetDao.getAssets(ownerName).get(0).getAssetName(), is("MBP"));
    }

    @Test
    public void should_get_other_sorted_asset_list_when_give_owner_name() throws Exception {
        List<Asset> assets = Arrays.asList(
                new Asset("Nokia", "17006011", "2014-04-20", "Mobile", "yansiyu"),
                new Asset("MBP", "17005800", "2014-04-28", "lap top", "lvjing"),
                new Asset("Screen", "17006036", "2014-06-16", "Others", "lvjing")
        );
        when(assetDao.getOthersAssets("yansiyu")).thenReturn(assets);

        String ownerName = "yansiyu";
        assetService.getAssetsExceptOwner(ownerName);
        verify(assetDao).getOthersAssets(ownerName);
        assertThat(assetDao.getOthersAssets(ownerName).get(0).getOwnerName(), is("lvjing"));

    }



    @Test(expected = RuntimeException.class)
    public void should_get_exception_when_get_my_asset_by_owner_name() throws Exception {
        List<Asset> assets = Arrays.asList(
                new Asset("Nokia", "17006011", "2014-04-20", "Mobile", "yansiyu"),
                null
        );
        when(assetDao.getAssets("yansiyu")).thenReturn(assets);

        String ownerName = "yansiyu";
        assetService.getAssetsByOwnerName(ownerName);

    }
    @Test(expected = RuntimeException.class)
    public void should_get_exception_when_get_other_asset_by_owner_name() throws Exception {
        List<Asset> assets = Arrays.asList(
                new Asset("Nokia", "17006011", "2014-04-20", "Mobile", "yansiyu"),
                null
        );
        when(assetDao.getOthersAssets("yansiyu")).thenReturn(assets);

        String ownerName = "yansiyu";
        assetService.getAssetsExceptOwner(ownerName);
    }
}