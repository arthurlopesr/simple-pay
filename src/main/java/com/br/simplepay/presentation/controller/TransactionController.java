package com.br.simplepay.presentation.controller;

import com.br.simplepay.domain.entities.TransactionEntity;
import com.br.simplepay.usecases.TransactionUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionUseCase transactionUseCase;

    public TransactionController(TransactionUseCase transactionUseCase) {
        this.transactionUseCase = transactionUseCase;
    }

    @PostMapping
    public ResponseEntity<TransactionEntity> createTransaction(@RequestBody TransactionEntity transaction) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionUseCase.createTransaction(transaction));
    }

    @GetMapping
    public ResponseEntity<List<TransactionEntity>> getAllTransaction() {
        return ResponseEntity.status(HttpStatus.OK).body(transactionUseCase.getAllTransaction());
    }
}
