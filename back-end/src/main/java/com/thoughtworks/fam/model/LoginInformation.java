package com.thoughtworks.fam.model;

import org.springframework.http.HttpStatus;

public class LoginInformation {
    private HttpStatus errorCode;
    private String errorMessage;

    public LoginInformation(HttpStatus errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public LoginInformation() {

    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
