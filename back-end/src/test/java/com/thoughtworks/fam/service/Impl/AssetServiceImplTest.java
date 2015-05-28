package com.thoughtworks.fam.service.Impl;

import com.thoughtworks.fam.dao.AssetDao;
import com.thoughtworks.fam.domain.NewAsset;
import com.thoughtworks.fam.exception.CreateAssetException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class AssetServiceImplTest {

    @Mock
    private AssetDao assetDao;

    @InjectMocks
    private AssetServiceImpl assetService;

    @Test
    public void should_create_asset_success_when_serialName_has_not_existed() throws Exception {
        given(assetDao.findAssetsBySerialName("17006011")).willReturn(null);
        given(assetDao.save(any(NewAsset.class))).willReturn(new NewAsset("Nokia", "17006011"));

        NewAsset newAsset= assetService.save(new NewAsset("Nokia", "17006011"));

        assertThat(newAsset.getSerialName(), is("17006011"));

    }

    @Test(expected = CreateAssetException.class)
    public void should_create_asset_failed_when_serialName_has_existed() {
        given(assetDao.findAssetsBySerialName("17006011")).willReturn(new NewAsset("Nokia", "17006011"));
        NewAsset newAsset = new NewAsset("Nokia", "17006011");
        assetService.save(newAsset);
    }
}