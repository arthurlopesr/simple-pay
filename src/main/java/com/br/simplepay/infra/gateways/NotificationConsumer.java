package com.br.simplepay.infra.gateways;

import com.br.simplepay.domain.entities.NotificationEntity;
import com.br.simplepay.domain.entities.TransactionEntity;
import com.br.simplepay.domain.exceptions.NotificationExceptions;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class NotificationConsumer {
    private RestClient restClient;

    public NotificationConsumer(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://util.devi.tools/api/v1/notify")
                .build();
    }

    @KafkaListener(topics = "transaction-notification", groupId = "simplepay")
    public void receiveNotification(TransactionEntity transaction) {
        var response = restClient.get()
                .retrieve()
                .toEntity(NotificationEntity.class);

        if (response.getStatusCode().isError() || !response.getBody().message()) {
            throw new NotificationExceptions("Error sending notification");
        }
    }
}
