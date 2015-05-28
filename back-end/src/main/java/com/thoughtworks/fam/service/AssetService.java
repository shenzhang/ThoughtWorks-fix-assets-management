package com.thoughtworks.fam.service;

import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.domain.NewAsset;

import java.util.List;


public interface AssetService {

    Asset save(Asset asset);

    List<Asset> findAll();

    List<Asset> findAssetsByUserName(String userName);

    NewAsset save(NewAsset newAsset);
}
