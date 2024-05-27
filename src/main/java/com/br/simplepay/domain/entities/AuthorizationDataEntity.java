package com.br.simplepay.domain.entities;

public record AuthorizationDataEntity(
        boolean authorization
) {
    public boolean isAuthorized() {
        return authorization;
    }
}
