package com.example.apipedidos.exceptions;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 4928599035264976211L;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable t) {
        super(t);
    }
}

