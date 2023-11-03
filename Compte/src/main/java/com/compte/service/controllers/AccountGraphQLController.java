package com.compte.service.controllers;

import com.compte.service.dtos.AccountDto;
import com.compte.service.dtos.AccountRequestDto;
import com.compte.service.dtos.AccountResponseDto;
import com.compte.service.exceptions.AccountNotFoundException;
import com.compte.service.models.Account;
import com.compte.service.repositories.AccountRepository;
import com.compte.service.services.AccountService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class AccountGraphQLController {

    private AccountRepository accountRepository;
    private AccountService accountService;

    @QueryMapping
    public List<Account> accounts() {
        return this.accountRepository.findAll();
    }

    @QueryMapping
    public Account accountById(@Argument String id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
    }

    @MutationMapping
    public AccountResponseDto addAccount(@Argument AccountRequestDto accountDto) {
        return accountService.save(accountDto);
    }

    @MutationMapping
    public AccountResponseDto updateAccount(@Argument AccountRequestDto accountDto, @Argument String id) throws AccountNotFoundException {
        return accountService.update(accountDto, id);
    }

    @MutationMapping
    public Boolean deleteAccount(@Argument String id) throws AccountNotFoundException {
       accountService.deleteAccount(id);
       return true;
    }
}
