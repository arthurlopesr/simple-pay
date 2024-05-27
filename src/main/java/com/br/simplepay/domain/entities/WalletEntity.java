package com.br.simplepay.domain.entities;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public record WalletEntity(
        @Id
        Long walletId,

        String fullName,
        String cpf,
        String email,
        String password,
        int type,
        BigDecimal balance
) {
}
