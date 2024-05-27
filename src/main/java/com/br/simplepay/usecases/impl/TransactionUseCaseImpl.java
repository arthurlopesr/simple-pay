package com.br.simplepay.usecases.impl;

import com.br.simplepay.domain.entities.TransactionEntity;
import com.br.simplepay.domain.entities.WalletEntity;
import com.br.simplepay.domain.enums.WalletTypeEnum;
import com.br.simplepay.domain.exceptions.InvalidTransactionException;
import com.br.simplepay.infra.repositories.TransactionsRepository;
import com.br.simplepay.infra.repositories.WalletRepository;
import com.br.simplepay.usecases.AuthorizerUseCase;
import com.br.simplepay.usecases.NotificationUseCase;
import com.br.simplepay.usecases.TransactionUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionUseCaseImpl implements TransactionUseCase {
    private final TransactionsRepository transactionsRepository;
    private final WalletRepository walletRepository;
    private final AuthorizerUseCase authorizerUseCase;
    private final NotificationUseCase notificationUseCase;

    public TransactionUseCaseImpl(TransactionsRepository transactionsRepository, WalletRepository walletRepository, AuthorizerUseCase authorizerUseCase, NotificationUseCase notificationUseCase) {
        this.transactionsRepository = transactionsRepository;
        this.walletRepository = walletRepository;
        this.authorizerUseCase = authorizerUseCase;
        this.notificationUseCase = notificationUseCase;
    }

    @Override
    @Transactional
    public TransactionEntity createTransaction(TransactionEntity transaction) {
        validate(transaction);
        var newTransaction = transactionsRepository.save(transaction);
        var wallet = walletRepository.findById(transaction.payer()).get();
        walletRepository.save(wallet.debit(transaction.value()));
        authorizerUseCase.authorize(transaction);
        notificationUseCase.notify(transaction);
        return newTransaction;
    }

    @Override
    public List<TransactionEntity> getAllTransaction() {
        return transactionsRepository.findAll();
    }

    private void validate(TransactionEntity transaction) {
        walletRepository.findById(transaction.payee())
                .map(payee -> walletRepository.findById(transaction.payer())
                        .map(payer -> isTransactionValid(transaction, payer) ? transaction : null)
                        .orElseThrow(() -> new InvalidTransactionException("Invalid transaction - %s".formatted(transaction))))
                .orElseThrow(() -> new InvalidTransactionException("Invalid transaction - %s".formatted(transaction)));
    }

    private static boolean isTransactionValid(TransactionEntity transaction, WalletEntity payer) {
        return payer.type() == WalletTypeEnum.COMUM.getValue() &&
                payer.balance().compareTo(transaction.value()) >= 0 &&
                !payer.walletId().equals(transaction.payee());
    }
}
