package com.compte.service.controllers;

import com.compte.service.models.Account;
import com.compte.service.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountGraphQLController {

    @Autowired
    private AccountRepository accountRepository;

    @QueryMapping
    public List<Account> accounts() {
        return this.accountRepository.findAll();
    }

    @QueryMapping
    public Account accountById(@Argument String id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
    }
}
