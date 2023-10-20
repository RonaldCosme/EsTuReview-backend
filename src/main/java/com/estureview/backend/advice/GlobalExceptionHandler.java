package com.estureview.backend.advice;

import com.estureview.backend.dtos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ Exception.class }) // Puedes agregar más excepciones específicas si lo deseas
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage(e.getMessage());

        if (e instanceof BadCredentialsException) {
            error.setStatus(HttpStatus.UNAUTHORIZED.value());
            return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
        }

        // Aquí puedes manejar otros tipos de excepciones y darles diferentes códigos de estado y mensajes

        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()); // Por defecto, si no se trata de ninguna excepción conocida
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}