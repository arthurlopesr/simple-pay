package com.br.simplepay.usecases;

import com.br.simplepay.domain.entities.TransactionEntity;

import java.util.List;

public interface TransactionUseCase {
    TransactionEntity createTransaction(TransactionEntity transaction);

    List<TransactionEntity> getAllTransaction();
}
