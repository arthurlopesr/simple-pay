package com.br.simplepay.usecases.impl;

import com.br.simplepay.domain.entities.AuthorizationEntity;
import com.br.simplepay.domain.entities.TransactionEntity;
import com.br.simplepay.domain.exceptions.UnauthorizedTransactionException;
import com.br.simplepay.usecases.AuthorizerUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AuthorizerUseCaseImpl implements AuthorizerUseCase {
    private RestClient restClient;

    public AuthorizerUseCaseImpl(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://util.devi.tools/api/v2/authorize")
                .build();
    }

    @Override
    public void authorize(TransactionEntity transaction) {
        var response = restClient.get()
                .retrieve()
                .toEntity(AuthorizationEntity.class);
        if (response.getStatusCode().isError() || response.getBody().isAuthorized()) {
            throw new UnauthorizedTransactionException("Unauthorized transaction!");
        }
    }
}
