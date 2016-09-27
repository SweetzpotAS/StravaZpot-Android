package com.sweetzpot.stravazpot.common.api.exception;

public class StravaAPIException extends RuntimeException{
    public StravaAPIException() {
    }

    public StravaAPIException(String message) {
        super(message);
    }

    public StravaAPIException(String message, Throwable cause) {
        super(message, cause);
    }

    public StravaAPIException(Throwable cause) {
        super(cause);
    }
}
