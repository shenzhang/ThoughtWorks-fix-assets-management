package com.thoughtworks.fam.service;

import com.thoughtworks.fam.model.Asset;

import java.util.List;

/**
 * Created by SiyuYan on 15-5-2.
 */
public interface AssetService {
    public List<Asset> getAssetsByOwnerName(String ownerName);
}
