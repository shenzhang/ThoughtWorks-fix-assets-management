package com.thoughtworks.fam.service;


import org.json.JSONObject;

public interface AuthService {

    JSONObject validate(String user, String password);
}
