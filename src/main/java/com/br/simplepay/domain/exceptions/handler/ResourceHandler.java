package com.br.simplepay.domain.exceptions.handler;

import com.br.simplepay.domain.exceptions.InvalidTransactionException;
import com.br.simplepay.presentation.error.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceHandler {
    @ExceptionHandler(InvalidTransactionException.class)
    public ResponseEntity<ErrorResponseDTO> invalidTransactionException(InvalidTransactionException invalidTransactionException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDTO.builder()
                .message(invalidTransactionException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }
}
