package com.thoughtworks.fam.exception;

public class ErrorInfo {
    public final String url;
    public final String ex;

    public ErrorInfo(String url, Exception ex) {
        this.url = url;
        this.ex = ex.getLocalizedMessage();
    }

    public ErrorInfo(StringBuffer requestURL, Exception ex) {
        this.url = requestURL.toString();
        this.ex = ex.getLocalizedMessage();
    }
}
