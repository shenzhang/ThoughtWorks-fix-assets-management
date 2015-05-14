package com.thoughtworks.fam.service;

import com.thoughtworks.fam.model.Asset;

import java.util.List;


public interface AssetService {

    Asset save(Asset asset);

    List<Asset> findAll();

    List<Asset> findAssetsByUserName(String userName);

}
