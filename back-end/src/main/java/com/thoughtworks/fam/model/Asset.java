package com.thoughtworks.fam.model;

public class Asset {
    private String assetName;
    private String number;
    private String assignDate;
    private String type;
    private String ownerName;

    public String getOwnerName() {
        return ownerName;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getNumber() {
        return number;
    }

    public Asset() {

    }

    public Asset(String assetName, String number, String assignDate, String type, String ownerName) {
        this.assetName = assetName;
        this.number = number;
        this.assignDate = assignDate;
        this.type = type;
        this.ownerName = ownerName;
    }

    public String getAssignDate() {
        return assignDate;
    }

    public String getType() {
        return type;
    }

    public Asset withAssetName(String assetName) {
        this.assetName = assetName;
        return this;
    }

    public Asset withNumber(String number) {
        this.number = number;
        return this;
    }

    public Asset withAssignedDate(String assignedDate) {
        this.assignDate = assignedDate;
        return this;
    }

    public Asset withType(String type) {
        this.type = type;
        return this;
    }

    public void withOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
