package com.github.kinderenge.ms_books.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    // RuntimeException não precisa de try-catch
    // Custom Exception para quando não encontrar o recurso
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
