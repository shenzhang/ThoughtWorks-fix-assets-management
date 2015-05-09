package com.thoughtworks.fam.service.Impl;

import com.thoughtworks.fam.dao.AssetDao;
import com.thoughtworks.fam.model.Asset;
import com.thoughtworks.fam.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static java.util.Collections.sort;

@Service
public class AssetServiceImpl implements AssetService {
    @Autowired
    private AssetDao assetDao;


    @Override
    public List<Asset> getAssetsByOwnerName(String ownerName){
        List<Asset> assets = assetDao.getAssets(ownerName);
        sort(assets, new Comparator<Asset>() {

            public int compare(Asset asset1, Asset asset2){
                if (asset1 == null || asset2 == null)
                    throw new RuntimeException("my assets can not be null");
                return (asset1.getAssetName().compareTo(asset2.getAssetName()));
            }
        });
        return assets;
    }

    @Override
    public List<Asset> getAssetsExceptOwner(String ownerName) {
        List<Asset> assets = assetDao.getOthersAssets(ownerName);
        sort(assets, new Comparator<Asset>() {

            public int compare(Asset asset1, Asset asset2) {
                if (asset1 == null || asset2 == null)
                    throw new RuntimeException("others assets can not be null");
                return (asset1.getOwnerName().compareTo(asset2.getOwnerName()));
            }
        });
        return assets;
    }

}