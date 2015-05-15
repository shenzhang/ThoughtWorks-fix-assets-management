package com.thoughtworks.fam.service.Impl;

import com.thoughtworks.fam.service.AuthService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public JSONObject validate(String user, String password) {
        return new JSONObject();
    }

}
