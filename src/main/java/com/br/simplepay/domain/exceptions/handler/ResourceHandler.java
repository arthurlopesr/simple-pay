package com.br.simplepay.domain.exceptions.handler;

import com.br.simplepay.domain.exceptions.InvalidTransactionException;
import com.br.simplepay.domain.exceptions.NotificationExceptions;
import com.br.simplepay.domain.exceptions.UnauthorizedTransactionException;
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

    @ExceptionHandler(UnauthorizedTransactionException.class)
    public ResponseEntity<ErrorResponseDTO> unauthorizedTransactionException(UnauthorizedTransactionException unauthorizedTransactionException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDTO.builder()
                .message(unauthorizedTransactionException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }

    @ExceptionHandler(NotificationExceptions.class)
    public ResponseEntity<ErrorResponseDTO> notificationExceptions(NotificationExceptions notificationExceptions) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDTO.builder()
                .message(notificationExceptions.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }
}
