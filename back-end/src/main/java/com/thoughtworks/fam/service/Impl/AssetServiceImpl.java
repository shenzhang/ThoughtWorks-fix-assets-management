package com.thoughtworks.fam.service.Impl;

import com.thoughtworks.fam.dao.AssetDao;
import com.thoughtworks.fam.model.Asset;
import com.thoughtworks.fam.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {
    @Autowired
    private AssetDao assetDao;

    @Override
    public Asset save(Asset asset) {
        return assetDao.save(asset);
    }

    @Override
    public List<Asset> findAll() {
        return assetDao.findAll();
    }

    @Override
    public List<Asset> findAssetsByUserName(String userName) {
        return assetDao.findAssetsByUserName(userName);
    }



}
