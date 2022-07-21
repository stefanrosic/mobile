package com.mobile.service.exception;

public class MobileAlreadyExistsException extends RuntimeException {

    public static final String MESSAGE = "Mobile with name '%s' already exists! Choose other name.";

    public MobileAlreadyExistsException(String name) {
        super(String.format(MESSAGE, name));
    }
}
