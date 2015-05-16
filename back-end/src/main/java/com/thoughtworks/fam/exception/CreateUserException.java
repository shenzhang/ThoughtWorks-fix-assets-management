package com.thoughtworks.fam.exception;

import org.springframework.http.HttpStatus;

public class CreateUserException extends RuntimeException {


    private HttpStatus httpStatus;

    private String errMessage;


    public CreateUserException(HttpStatus httpStatus, String errMessage) {
        this.httpStatus = httpStatus;
        this.errMessage = errMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
