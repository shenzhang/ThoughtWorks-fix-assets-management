package com.thoughtworks.fam.resource;

import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.domain.Json.CreateUserJson;
import com.thoughtworks.fam.domain.User;
import com.thoughtworks.fam.service.AssetService;
import com.thoughtworks.fam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<List<Asset>> getAssets(@PathVariable String userName) throws ParseException {
        if (isNullOrEmpty(userName)){
            return null;
        }
        List<Asset> assets = assetService.findAssetsByUserName(userName);
        return new ResponseEntity<List<Asset>>(assets, HttpStatus.OK);
    }

    @RequestMapping(value = "/allassets", method = GET)
    public ResponseEntity<List<Asset>> getAllAssets() {

        List<Asset> allAssets = assetService.findAll();
        return new ResponseEntity<List<Asset>>(allAssets, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = POST)
    public ResponseEntity<CreateUserJson> create(@RequestBody User user) {

        String name = user.getName();
        User savedUser = userService.save(name);
        CreateUserJson createUserJson = new CreateUserJson();
        if (savedUser != null) {
            createUserJson.setMessage("create user success");
            return new ResponseEntity<CreateUserJson>(createUserJson, HttpStatus.CREATED);
        }
        createUserJson.setMessage("create failed");
        return new ResponseEntity<CreateUserJson>(createUserJson, HttpStatus.CONFLICT);

    }

}
