package com.estureview.backend.exceptions;

import java.io.Serial;


public class BadRequestException extends RuntimeException {
@Serial
    private static final long serialVersionUID = 1L;

    public BadRequestException(String message) {
        super(message);
    }
}

//Lanzada cuando se envía una solicitud con datos inválidos: