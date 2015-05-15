package com.thoughtworks.fam.controller;

import com.thoughtworks.fam.model.Asset;
import com.thoughtworks.fam.model.User;
import com.thoughtworks.fam.service.AssetService;
import com.thoughtworks.fam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private AssetService assetService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userName}/assets", method = GET)
    public List<Asset> getAssets(@PathVariable String userName) throws ParseException {
        if (isNullOrEmpty(userName)){
            return null;
        }
        return assetService.findAssetsByUserName(userName);
    }

    @RequestMapping(value = "/allassets", method = GET)
    public ResponseEntity<List<Asset>> getAllAssets() {

        List<Asset> allAssets = assetService.findAll();
        return new ResponseEntity<List<Asset>>(allAssets, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = POST)
    public ResponseEntity<?> create(@RequestParam String userName) {
        User user = userService.save(userName);
        if (user !=null) {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        return new ResponseEntity<String>("create user failed", HttpStatus.UNAUTHORIZED);

    }

}
