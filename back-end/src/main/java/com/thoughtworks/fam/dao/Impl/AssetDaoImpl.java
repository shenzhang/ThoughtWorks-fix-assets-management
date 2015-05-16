package com.thoughtworks.fam.dao.Impl;

import com.thoughtworks.fam.dao.AssetDao;
import com.thoughtworks.fam.model.Asset;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class AssetDaoImpl implements AssetDao {
    private List<Asset> allAssetList = Arrays.asList(
            new Asset("Nokia", "17006011", "2014-04-20", "Mobile", "yansiyu"),
            new Asset("MBP", "17005800", "2014-04-28", "lap top", "yansiyu"),
            new Asset("Screen", "17006036", "2014-06-16", "Others", "yansiyu"),
            new Asset("Nokia", "17006011", "2014-04-20", "Mobile", "lvjing"),
            new Asset("MBP", "17005800", "2014-04-28", "lap top", "lvjing"),
            new Asset("Screen", "17006036", "2014-06-16", "Others", "lvjing"),
            new Asset("Nokia", "17006011", "2014-04-20", "Mobile", "jtao"),
            new Asset("MBP", "17005800", "2014-04-28", "lap top", "jtao"),
            new Asset("Screen", "17006036", "2014-06-16", "Others", "jtao")
    );

    private Map<String, List<Asset>> allAssets= new HashMap<String, List<Asset>>(){{
        put("ncmao", Arrays.asList(allAssetList.get(0), allAssetList.get(1)));
        put("qliu", Arrays.asList(allAssetList.get(2), allAssetList.get(3)));
        put("siyu", Arrays.asList(allAssetList.get(4), allAssetList.get(5)));
    }};

    @Override
    public Asset save(Asset asset) {
        return asset;
    }

    @Override
    public List<Asset> findAll() {
        return allAssetList;
    }

    @Override
    public List<Asset> findAssetsByUserName(String userName) {
        return allAssets.get(userName);
    }

}
