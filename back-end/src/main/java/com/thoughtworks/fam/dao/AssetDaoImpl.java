package com.thoughtworks.fam.dao;

import com.thoughtworks.fam.model.Asset;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AssetDaoImpl implements AssetDao {
    List<Asset> AllAssetList = Arrays.asList(
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

    @Override
    public List<Asset> getAssets(String ownerName) {
        return getAssets(new Only(ownerName));
    }

    @Override
    public List<Asset> getOthersAssets(String ownerName) {
        return getAssets(new Except(ownerName));
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
