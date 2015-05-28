package com.thoughtworks.fam.resource;

import com.thoughtworks.fam.domain.Json.CreateAssetJson;
import com.thoughtworks.fam.domain.NewAsset;
import com.thoughtworks.fam.service.AssetService;
import com.thoughtworks.fam.service.Impl.AssetServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/asset")
public class AssetController {

    @RequestMapping(value = "/create", method = POST)
    public ResponseEntity<CreateAssetJson> create(@RequestBody NewAsset newAsset) {
        CreateAssetJson createAssetJson = new CreateAssetJson();

        String serialName = newAsset.getSerialName();
        int serialNumber = Integer.parseInt(serialName);

        if (serialName.length() == 8) {
            AssetService assetService = new AssetServiceImpl();
            assetService.save(newAsset);

            createAssetJson.setMessage("success");
            return new ResponseEntity<CreateAssetJson>(createAssetJson, CREATED);
        }
        createAssetJson.setMessage("create failed");
        return new ResponseEntity<CreateAssetJson>(createAssetJson, CONFLICT);

    }
}
