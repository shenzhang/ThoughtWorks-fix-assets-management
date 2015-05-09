package com.thoughtworks.fam.dao;

public class Only implements Predicate<String> {
    private String ownerName;

    public Only(String ownerName) {
        this.ownerName = ownerName;
    }


    @Override
    public boolean test(String s) {
        return  s.equals(ownerName);
    }
}
