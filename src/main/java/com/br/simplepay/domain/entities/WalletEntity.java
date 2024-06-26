package com.br.simplepay.domain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table(name = "wallets")
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
    public WalletEntity debit(BigDecimal value) {
        return new WalletEntity(walletId, fullName, cpf, email, password, type, balance.subtract(value));
    }

    public WalletEntity credit(BigDecimal value) {
        return new WalletEntity(walletId, fullName, cpf, email, password, type, balance.add(value));
    }
}
