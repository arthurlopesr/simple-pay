CREATE TABLE if not exists `wallets`
(
    `wallet_id` INT            NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `full_name` CHAR(255)      NOT NULL,
    `cpf`       VARCHAR(100),
    `email`     VARCHAR(100),
    `password`  VARCHAR(100),
    `type`      INT,
    `balance`   DECIMAL(10, 2) NOT NULL,
    `version`   BIGINT
);

ALTER TABLE `wallets`
    ADD UNIQUE `wallets_email_unique` (`email`);

ALTER TABLE `wallets`
    ADD UNIQUE `wallets_cpf_unique` (`cpf`);

CREATE TABLE if not exists `transactions`
(
    `transaction_id` INT            NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `payer`          INT,
    `payee`          INT,
    `value`          DECIMAL(10, 2) NOT NULL,
    `created_at`     TIMESTAMP
);

ALTER TABLE
    `transactions`
    ADD CONSTRAINT `fk_transactions_payer` FOREIGN KEY (`payer`) REFERENCES `wallets` (`wallet_id`);

ALTER TABLE
    `transactions`
    ADD CONSTRAINT `fk_transactions_payee` FOREIGN KEY (`payee`) REFERENCES `wallets` (`wallet_id`);