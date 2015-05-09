package com.thoughtworks.fam.dao;

import com.thoughtworks.fam.model.Asset;

import java.util.List;

public interface AssetDao {
    public List<Asset> getAssets(String ownerName);
    public List<Asset> getOthersAssets(String ownerName);

    Asset save(Asset asset);

    List<Asset> findAll();

    List<Asset> findAssetsByUserName(String userName);
}
