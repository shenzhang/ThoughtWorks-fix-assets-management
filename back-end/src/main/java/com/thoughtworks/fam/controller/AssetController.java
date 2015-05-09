package com.thoughtworks.fam.controller;

import com.thoughtworks.fam.model.Asset;
import com.thoughtworks.fam.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "assets")
public class AssetController {
    @Autowired
    private AssetService assetService;

    @RequestMapping(method = GET, value = "/my/{ownerName}")
    public List<Asset> getAssets(@PathVariable("ownerName") String ownerName)  {
        return assetService.getAssetsByOwnerName(ownerName);
    }
    @RequestMapping(method = GET,value = "/other/{ownerName}")
    public List<Asset> getOtherAssets(@PathVariable("ownerName") String ownerName)  {
        return assetService.getAssetsExceptOwner(ownerName);
    }


}
