package com.thoughtworks.fam.domain;

import org.springframework.http.HttpStatus;

public class JSONObject {
    private HttpStatus statusCode;
    private String message;

    public JSONObject(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public JSONObject() {
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
