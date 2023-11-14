package com.diazero.incidentAPI.domain.exceptions;

public class EntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(String mensagem) {
        super(mensagem);
    }
}
