package com.br.simplepay.domain.entities;

public record AuthorizationEntity(
        String status,
        AuthorizationDataEntity authorizationData
) {
    public boolean isAuthorized() {
        return authorizationData !=null && authorizationData.isAuthorized();
    }
}
