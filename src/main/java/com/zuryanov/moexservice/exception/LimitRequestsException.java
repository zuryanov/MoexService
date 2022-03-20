package com.zuryanov.moexservice.exception;

public class LimitRequestsException extends RuntimeException {
    public LimitRequestsException(String message) {
        super(message);
    }
}
