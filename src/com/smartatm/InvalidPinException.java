package com.smartatm;

class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}
