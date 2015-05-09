package com.thoughtworks.fam.dao.Impl;

import com.thoughtworks.fam.dao.AssetDao;
import com.thoughtworks.fam.dao.Except;
import com.thoughtworks.fam.dao.Only;
import com.thoughtworks.fam.dao.Predicate;
import com.thoughtworks.fam.model.Asset;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class AssetDaoImpl implements AssetDao {
    private List<Asset> AllAssetList = Arrays.asList(
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
        put("ncmao", Arrays.asList(AllAssetList.get(0),AllAssetList.get(1)));
        put("qliu", Arrays.asList(AllAssetList.get(2),AllAssetList.get(3)));
        put("siyu", Arrays.asList(AllAssetList.get(4), AllAssetList.get(5)));
    }};

    @Override
    public List<Asset> getAssets(String ownerName) {
        return getAssets(new Only(ownerName));
    }

    @Override
    public List<Asset> getOthersAssets(String ownerName) {
        return getAssets(new Except(ownerName));
    }

    @Override
    public Asset save(Asset asset) {
        return null;
    }

    @Override
    public List<Asset> findAll() {
        return AllAssetList;
    }

    @Override
    public List<Asset> findAssetsByUserName(String userName) {
        return allAssets.get(userName);
    }

    private List<Asset> getAssets(Predicate<String> predicate) {
        List<Asset> assets = new ArrayList<Asset>();
        for (Asset asset : AllAssetList) {
            if (predicate.test(asset.getOwnerName()))
                assets.add(asset);
        }
        return assets;
    }
}
