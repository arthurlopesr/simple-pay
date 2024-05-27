package com.br.simplepay.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public record AuthorizationEntity(
        String status,
        AuthorizationDataEntity authorizationData
) {
    public boolean isAuthorized() {
        return authorizationData !=null && authorizationData.isAuthorized();
    }
}
