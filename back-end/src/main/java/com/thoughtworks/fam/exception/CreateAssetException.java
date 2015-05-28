package com.thoughtworks.fam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CreateAssetException extends RuntimeException{
    private HttpStatus httpStatus;

    public CreateAssetException(String errMessage) {
        super(errMessage);
    }
    public CreateAssetException(HttpStatus httpStatus, String errMessage) {
        super(errMessage);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
