package com.mobile.service.exception;

public class MobileNotFoundException extends RuntimeException  {

    public static final String MESSAGE = "Mobile with %s does not exist.";

    public MobileNotFoundException(String id) {
        super(String.format(MESSAGE, id));
    }
}
