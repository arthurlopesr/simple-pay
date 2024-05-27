package com.br.simplepay;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.config.TopicBuilder;

@EnableJdbcAuditing
@EnableJpaRepositories
@SpringBootApplication
public class SimplePayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimplePayApplication.class, args);
    }

    @Bean
    NewTopic notificationTopic() {
        return TopicBuilder.name("transaction-notification").build();
    }
}
