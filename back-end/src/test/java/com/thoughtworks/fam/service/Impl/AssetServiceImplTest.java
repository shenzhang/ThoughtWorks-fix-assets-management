package com.thoughtworks.fam.service.Impl;

import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.exception.CreateAssetException;
import com.thoughtworks.fam.repository.AssetRepository;
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
    private AssetRepository assetRepository;

    @InjectMocks
    private AssetServiceImpl assetService;

    @Test
    public void should_create_asset_success_when_serialName_has_not_existed() throws Exception {

        Asset asset = new Asset().withAssetName("Nokia").withNumber("17006011");
        given(assetRepository.findByNumber("17006011")).willReturn(null);
        given(assetRepository.save(any(Asset.class))).willReturn(asset);

        assetService.save(asset);
        assertThat(asset.getNumber(), is("17006011"));

    }

    @Test(expected = CreateAssetException.class)
    public void should_create_asset_failed_when_number_has_existed() {
        Asset asset = new Asset().withAssetName("Nokia").withNumber("17006011");

        given(assetRepository.findByNumber("17006011")).willReturn(asset);

        assetService.save(asset);
    }
}