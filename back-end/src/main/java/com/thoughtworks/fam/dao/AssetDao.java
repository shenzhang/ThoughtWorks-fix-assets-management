package com.thoughtworks.fam.dao;

import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.domain.NewAsset;

import java.util.List;

public interface AssetDao {

    Asset save(Asset asset);

    List<Asset> findAll();

    List<Asset> findAssetsByUserName(String userName);

    NewAsset save(NewAsset newAsset);

    NewAsset findAssetsBySerialName(String serialName);
}
