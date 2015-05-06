package com.thoughtworks.fam.dao;

import com.thoughtworks.fam.model.Asset;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by SiyuYan on 15-5-2.
 */
@Repository
public class AssetDaoImpl implements AssetDao {
    @Override
    public List assetList(String ownerName) {
        List<Asset> assets = new ArrayList<Asset>();

        Asset asset = new Asset("Nokia", "17006011", "2014-04-20", "Mobile","yansiyu");
        Asset asset2 = new Asset("MBP", "17005800", "2014-04-28", "lap top","yansiyu");
        Asset asset3 = new Asset("Screen", "17006036", "2014-06-16", "Others","yansiyu");

        if (asset.getOwnerName().equals(ownerName))
        assets.add(asset);
        if (asset2.getOwnerName().equals(ownerName))
        assets.add(asset2);
        if (asset3.getOwnerName().equals(ownerName))
        assets.add(asset3);

        Collections.sort(assets, new Comparator<Object>() {

            public int compare(Object o1, Object o2) {
                Asset p1 = (Asset) o1;
                Asset p2 = (Asset) o2;
                return (p1.getassetName().compareTo(p2.getassetName()));
            }
        });
        return assets;
    }
}
