package com.thoughtworks.fam.resource;

import com.thoughtworks.fam.domain.Json.CreateAssetJson;
import com.thoughtworks.fam.domain.NewAsset;
import com.thoughtworks.fam.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/asset")
public class AssetController {
    @Autowired
    private AssetService assetService;

    @RequestMapping(value = "/create", method = POST)
    public ResponseEntity<CreateAssetJson> create(@RequestBody NewAsset newAsset){
        CreateAssetJson createAssetJson = new CreateAssetJson();

        String serialName = newAsset.getSerialName();
        if (isNumeric(serialName)) {
            if (serialName.length() == 8) {
                assetService.save(newAsset);

                createAssetJson.setMessage("success");
                return new ResponseEntity<CreateAssetJson>(createAssetJson, CREATED);
            }
        }

        createAssetJson.setMessage("Name should be made up of 8 numbers.");
        return new ResponseEntity<CreateAssetJson>(createAssetJson, CONFLICT);

    }


    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
