package com.thoughtworks.fam.service;

import com.thoughtworks.fam.dao.AssetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SiyuYan on 15-5-2.
 */
@Service
public class AssetServiceImpl implements AssetService {
    @Autowired
    private AssetDao assetDao;


    @Override
    public List getAssetListByOwnerName(String ownerName) {

        return assetDao.assetList(ownerName);
    }

}