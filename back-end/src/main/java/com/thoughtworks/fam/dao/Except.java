package com.thoughtworks.fam.dao;


public class Except implements Predicate<String> {
    private String ownerName;

    public Except(String ownerName){
        this.ownerName = ownerName;
    }

    @Override
    public boolean test(String s) {
        return !s.equals(ownerName);
    }
}