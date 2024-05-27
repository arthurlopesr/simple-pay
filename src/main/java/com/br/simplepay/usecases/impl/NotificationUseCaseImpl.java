package com.br.simplepay.usecases.impl;

import com.br.simplepay.domain.entities.TransactionEntity;
import com.br.simplepay.usecases.NotificationUseCase;
import org.springframework.stereotype.Service;

@Service
public class NotificationUseCaseImpl implements NotificationUseCase {

    @Override
    public void notify(TransactionEntity transaction) {

    }
}
