package com.estureview.backend.exceptions;

import java.io.Serial;

public class ConflictException extends RuntimeException {
@Serial
    private static final long serialVersionUID = 1L;

    public ConflictException(String message) {
        super(message);
    }
}

//Lanzada cuando ocurre un conflicto, por ejemplo, tratar de registrar un email que ya está en uso:
