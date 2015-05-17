package com.thoughtworks.fam.exception;

import org.springframework.http.HttpStatus;

public class ErrorInfo {
    public final HttpStatus httpStatus;
    public final String errMessage;

    public ErrorInfo(HttpStatus httpStatus, String errMessage) {
        this.httpStatus = httpStatus;
        this.errMessage = errMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getErrMessage() {
        return errMessage;
    }
}
