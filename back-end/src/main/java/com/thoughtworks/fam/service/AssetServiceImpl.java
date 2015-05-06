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

        return orderAssets(assetDao.getAssets(ownerName));
    }

    private List<Asset> orderAssets(List<Asset> assets) {
        Collections.sort(assets, new Comparator<Object>() {

            public int compare(Object o1, Object o2) {
                Asset p1 = (Asset) o1;
                Asset p2 = (Asset) o2;
                return (p1.getAssetName().compareTo(p2.getAssetName()));
            }
        });
        return assets;
    }

}