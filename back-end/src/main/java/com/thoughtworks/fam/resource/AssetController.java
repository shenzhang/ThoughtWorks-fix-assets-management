package com.thoughtworks.fam.resource;

import com.thoughtworks.fam.domain.Asset;
import com.thoughtworks.fam.domain.Json.CreateAssetJson;
import com.thoughtworks.fam.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/asset")
public class AssetController {
    @Autowired
    private AssetService assetService;

    @RequestMapping(value = "/create", method = POST)
    public ResponseEntity<CreateAssetJson> create(@RequestBody Asset asset) {

        CreateAssetJson createAssetJson = new CreateAssetJson();
        assetService.save(asset);
        createAssetJson.setMessage("success");
        return new ResponseEntity<CreateAssetJson>(createAssetJson, HttpStatus.CREATED);

    }


    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
