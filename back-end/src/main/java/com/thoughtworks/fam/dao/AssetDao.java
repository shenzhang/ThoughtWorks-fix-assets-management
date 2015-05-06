package com.thoughtworks.fam.dao;

import com.thoughtworks.fam.model.Asset;

import java.util.List;

/**
 * Created by SiyuYan on 15-5-2.
 */
public interface AssetDao {
    public List assetList(String ownerName);
}
