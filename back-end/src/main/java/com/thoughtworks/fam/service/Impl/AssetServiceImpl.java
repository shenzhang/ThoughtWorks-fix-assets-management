package com.thoughtworks.fam.service.Impl;

import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.exception.CreateAssetException;
import com.thoughtworks.fam.repository.AssetRepository;
import com.thoughtworks.fam.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AssetServiceImpl implements AssetService {
    @Autowired
    private AssetRepository assetRepository;

    @Override
    public Asset save(Asset asset) {
        if (asset.getNumber().length() != 8) {
            throw new CreateAssetException("Name should be made up of 8 numbers.");
        }
        if (assetRepository.findByNumber(asset.getNumber()) != null) {
            throw new CreateAssetException("The name already exist, please use another one.");
        }

        return assetRepository.save(asset);
    }

    @Override
    public List<Asset> findAll() {
        return assetRepository.findAll();
    }

    @Override
    public List<Asset> findByUserName(String userName) {
        return assetRepository.findByUserName(userName);
    }
}
