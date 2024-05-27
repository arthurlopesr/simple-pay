package com.br.simplepay.infra.repositories;

import com.br.simplepay.domain.entities.TransactionEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends ListCrudRepository<TransactionEntity, Long> {
}
