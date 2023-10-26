package com.compte.service;

import com.compte.service.enums.AccountType;
import com.compte.service.models.Account;
import com.compte.service.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class CompteApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteApplication.class, args);
    }

   // @Bean
    CommandLineRunner start(AccountRepository accountRepository) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                Account account = new Account()
                        .builder()
                        .id(UUID.randomUUID().toString())
                        .balance(100 + Math.random() * 500)
                        .accountType(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT :AccountType.SAVING_ACCOUNT)
                        .currency("MAD")
                        .createdAt(new Date())
                        .build();
                accountRepository.save(account);
            }
        };
    }
}
