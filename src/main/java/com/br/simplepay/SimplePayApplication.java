package com.br.simplepay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJdbcAuditing
@EnableJpaRepositories
@SpringBootApplication
public class SimplePayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimplePayApplication.class, args);
    }

}
