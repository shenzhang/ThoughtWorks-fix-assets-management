package com.thoughtworks.fam.service;

import com.thoughtworks.fam.model.Asset;

import java.util.List;


public interface AssetService {
    public List<Asset> getAssetsByOwnerName(String ownerName);

    public List<Asset> getAssetsExceptOwner(String ownerName);

    Asset save(Asset asset);

    List<Asset> findAll();

    List<Asset> findAssetsByUserName(String userName);

}
