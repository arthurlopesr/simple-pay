package com.br.simplepay.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public record AuthorizationDataEntity(
        boolean authorization
) {
    public boolean isAuthorized() {
        return authorization;
    }
}
