package com.thoughtworks.fam.domain;

public class NewAsset {
    String type;
    String serialName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerialName() {
        return serialName;
    }

    public void setSerialName(String serialName) {
        this.serialName = serialName;
    }

    public NewAsset(String type, String serialName) {

        this.type = type;
        this.serialName = serialName;
    }
}
