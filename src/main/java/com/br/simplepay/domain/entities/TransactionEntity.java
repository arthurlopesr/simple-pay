package com.br.simplepay.domain.entities;

import jakarta.persistence.Column;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "transactions")
public record TransactionEntity(
        @Id
        Long transactionId,

        Long payer,
        Long payee,
        BigDecimal value,

        @CreatedDate
        @Column(name = "created_at")
        LocalDateTime createdAt
) {
    public TransactionEntity {
        value = value.setScale(2);
    }
}
