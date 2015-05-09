package com.thoughtworks.fam.dao;


public interface Predicate<T> {
    boolean test(T t);
}
