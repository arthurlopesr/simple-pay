package com.br.simplepay.usecases;

import com.br.simplepay.domain.entities.TransactionEntity;

public interface NotificationUseCase {
    void notify(TransactionEntity transaction);
}
