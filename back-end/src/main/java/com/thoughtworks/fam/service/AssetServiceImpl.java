package com.thoughtworks.fam.service;

import com.thoughtworks.fam.dao.AssetDao;
import com.thoughtworks.fam.model.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by SiyuYan on 15-5-2.
 */
@Service
public class AssetServiceImpl implements AssetService {
    @Autowired
    private AssetDao assetDao;


    @Override
    public List<Asset> getAssetsByOwnerName(String ownerName) {

        List<Asset> assets = assetDao.getAssets(ownerName);
        Collections.sort(assets, new Comparator<Asset>() {

            public int compare( Asset p1, Asset p2) {
                return (p1.getAssetName().compareTo(p2.getAssetName()));
            }
        });
        return assets;
    }

}