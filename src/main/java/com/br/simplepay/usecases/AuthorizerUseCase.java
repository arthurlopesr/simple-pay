package com.br.simplepay.usecases;

import com.br.simplepay.domain.entities.TransactionEntity;

public interface AuthorizerUseCase {
    void authorize(TransactionEntity transaction);
}
