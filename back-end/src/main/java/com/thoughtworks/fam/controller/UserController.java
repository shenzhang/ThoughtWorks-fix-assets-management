package com.thoughtworks.fam.controller;

import com.thoughtworks.fam.model.Asset;
import com.thoughtworks.fam.model.AssetJson;
import com.thoughtworks.fam.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.thoughtworks.fam.model.AssetJson.map;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private AssetService assetService;

    @RequestMapping(value = "/{userName}/assets", method = GET)
    public List<Asset> getAssets(@PathVariable String userName) throws ParseException {

        if (userName ==null || userName.isEmpty()) {
            return null;
        }
        return assetService.findAssetsByUserName(userName);
    }

    @RequestMapping(value = "/allassets", method = GET)
    public AssetJson getAllAssets() {

        List<Asset> allAssets = new ArrayList<Asset>();
        return map(allAssets);
    }

    @RequestMapping(value = "/create", method = POST)
    public boolean create(@RequestParam String email) {
        return assetService.createUser(email);
    }

    @RequestMapping(value = "/login", method = POST)
    public boolean login(@RequestParam String userName, @RequestParam String password) {
        return assetService.isValid(userName, password);
    }

    public ResponseEntity<String> handle() throws URISyntaxException {
        URI location = new URI("").parseServerAuthority();
        return ResponseEntity.created(location).header("MyResponseHeader", "MyValue").body("Hello World");
    }
}
