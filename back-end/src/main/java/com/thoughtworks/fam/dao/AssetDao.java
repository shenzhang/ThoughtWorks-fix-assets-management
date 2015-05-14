package com.thoughtworks.fam.dao;

import com.thoughtworks.fam.model.Asset;

import java.util.List;

public interface AssetDao {

    Asset save(Asset asset);

    List<Asset> findAll();

    List<Asset> findAssetsByUserName(String userName);
}
