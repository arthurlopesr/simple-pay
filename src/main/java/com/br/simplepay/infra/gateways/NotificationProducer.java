package com.br.simplepay.infra.gateways;

import com.br.simplepay.domain.entities.TransactionEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {
    private final KafkaTemplate<String, TransactionEntity> kafkaTemplate;

    public NotificationProducer(KafkaTemplate<String, TransactionEntity> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNotification(TransactionEntity transaction) {
        kafkaTemplate.send("transaction-notification", transaction);
    }
}
