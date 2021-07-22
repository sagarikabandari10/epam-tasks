package com.epam.exception.main;

public class UniversityException extends Exception{
    public UniversityException() {
        super();
    }

    public UniversityException(String message) {
        super(message);
    }

    public UniversityException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniversityException(Throwable cause) {
        super(cause);
    }

    protected UniversityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
