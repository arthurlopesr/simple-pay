package com.br.simplepay.usecases.impl;

import com.br.simplepay.domain.entities.TransactionEntity;
import com.br.simplepay.domain.entities.WalletEntity;
import com.br.simplepay.domain.enums.WalletTypeEnum;
import com.br.simplepay.infra.repositories.TransactionsRepository;
import com.br.simplepay.infra.repositories.WalletRepository;
import com.br.simplepay.usecases.TransactionUseCase;
import org.springframework.stereotype.Service;

@Service
public class TransactionUseCaseImpl implements TransactionUseCase {
    private final TransactionsRepository transactionsRepository;
    private final WalletRepository walletRepository;

    public TransactionUseCaseImpl(TransactionsRepository transactionsRepository, WalletRepository walletRepository) {
        this.transactionsRepository = transactionsRepository;
        this.walletRepository = walletRepository;
    }

    @Override
    public TransactionEntity createTransaction(TransactionEntity transaction) {
        var newTrasaction = transactionsRepository.save(transaction);
        var wallet = walletRepository.findById(transaction.payer()).get();
        walletRepository.save(wallet.debit(transaction.value()));
        return newTrasaction;
    }

    private boolean validate(TransactionEntity transaction) {
        walletRepository.findById(transaction.payee())
                .flatMap(payee -> walletRepository.findById(transaction.payer())
                        .map(payer -> isTransactionValid(transaction, payer) ? transaction : null));

        return true;
    }

    private static boolean isTransactionValid(TransactionEntity transaction, WalletEntity payer) {
        return payer.type() == WalletTypeEnum.COMUM.getValue() &&
                payer.balance().compareTo(transaction.value()) >= 0 &&
                !payer.walletId().equals(transaction.payee());
    }
}
