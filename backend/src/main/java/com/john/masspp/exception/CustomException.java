package com.john.masspp.exception;

public class CustomException extends Exception {

    private static final long serialVersionUID = 8266156645512482655L;

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
