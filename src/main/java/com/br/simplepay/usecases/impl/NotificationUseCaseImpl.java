package com.br.simplepay.usecases.impl;

import com.br.simplepay.domain.entities.TransactionEntity;
import com.br.simplepay.infra.gateways.NotificationProducer;
import com.br.simplepay.usecases.NotificationUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationUseCaseImpl implements NotificationUseCase {
    private NotificationProducer notificationProducer;

    public NotificationUseCaseImpl(NotificationProducer notificationProducer) {
        this.notificationProducer = notificationProducer;
    }

    @Override
    public void notify(TransactionEntity transaction) {
        notificationProducer.sendNotification(transaction);
    }
}
