package com.thoughtworks.fam.domain.Json;

import com.thoughtworks.fam.domain.Asset;

import java.util.List;

public class AssetJson {

    private List<Asset> data;

    public AssetJson(List<Asset> data) {
        this.data = data;
    }

    public List<Asset> getData() {
        return data;
    }

    public void setData(List<Asset> data) {
        this.data = data;
    }

    public static AssetJson map(List<Asset> data){
        return new AssetJson(data);
    }
}
