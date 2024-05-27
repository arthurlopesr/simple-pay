package com.br.simplepay.infra.repositories;

import com.br.simplepay.domain.entities.WalletEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends CrudRepository<WalletEntity, Long> {
}
