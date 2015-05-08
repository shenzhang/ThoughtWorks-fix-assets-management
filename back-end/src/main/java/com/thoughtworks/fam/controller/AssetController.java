package com.thoughtworks.fam.controller;

import com.thoughtworks.fam.model.Asset;
import com.thoughtworks.fam.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by SiyuYan on 15-5-2.
 */
@RestController
@RequestMapping(value = "asset")
public class AssetController {
    @Autowired
    private AssetService assetService;

    @RequestMapping(method = RequestMethod.GET, value = "/{ownerName}")
    public List<Asset> getAssets(@PathVariable("ownerName") String ownerName)  {
        return assetService.getAssetsByOwnerName(ownerName);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/others/{ownerName}")
    public List<Asset> getAllAssets(@PathVariable("ownerName") String ownerName)  {
        return assetService.getAssetsExceptOwner(ownerName);
    }


}
