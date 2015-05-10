package com.thoughtworks.fam.controller;

import com.thoughtworks.fam.model.Asset;
import com.thoughtworks.fam.model.AssetJson;
import com.thoughtworks.fam.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.thoughtworks.fam.model.AssetJson.map;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private AssetService assetService;

    @RequestMapping(value = "/{userName}/assets", method = GET)
    public List<Asset> getAssets(@PathVariable String userName) throws ParseException {
        if (isNullOrEmpty(userName)){
            return null;
        }
        return assetService.findAssetsByUserName(userName);
    }

    @RequestMapping(value = "/allassets", method = GET)
    public AssetJson getAllAssets() {

        List<Asset> allAssets = new ArrayList<Asset>();
        return map(allAssets);
    }
}
