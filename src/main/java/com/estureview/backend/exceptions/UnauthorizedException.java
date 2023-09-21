package com.estureview.backend.exceptions;


import java.io.Serial;

public class UnauthorizedException extends RuntimeException {
@Serial
    private static final long serialVersionUID = 1L;

    public UnauthorizedException(String message) {
        super(message);
    }
}

// Lanzada cuando alguien trata de acceder a un recurso
//sin tener los permisos adecuados:
