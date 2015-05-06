package com.thoughtworks.fam.model;

/**
 * User: Zhang Shen
 * Date: 4/25/15
 * Time: 11:08 AM
 */
public class Asset {
    private String assetName;
    private String number;
    private String assignedDate;
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

    public Asset(String assetName, String number, String assignedDate, String type, String ownerName) {
        this.assetName = assetName;
        this.number = number;
        this.assignedDate = assignedDate;
        this.type = type;
        this.ownerName = ownerName;
    }

    public String getAssignedDate() {
        return assignedDate;
    }

    public String getType() {
        return type;
    }
}
