package com.estureview.backend.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {
@Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}

//Lanzada cuando no se encuentra un recurso
//(por ejemplo, un profesor, revisión, comentario, etc.)