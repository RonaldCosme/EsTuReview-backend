package com.estureview.backend.config;


public class BadCredentialsAppException extends RuntimeException {
    public BadCredentialsAppException(String message) {
        super(message);
    }

    // Puedes agregar más constructores si lo necesitas, por ejemplo, uno con la causa:
    public BadCredentialsAppException(String message, Throwable cause) {
        super(message, cause);
    }
}
