package com.br.simplepay.usecases;

import com.br.simplepay.domain.entities.TransactionEntity;

public interface TransactionUseCase {
    TransactionEntity createTransaction(TransactionEntity transaction);
}
