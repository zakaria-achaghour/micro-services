package com.compte.service.services.Impl;

import com.compte.service.dtos.AccountDto;
import com.compte.service.mappers.AccountMapper;
import com.compte.service.models.Account;
import com.compte.service.repositories.AccountRepository;
import com.compte.service.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private AccountMapper accountMapper;
    @Override
    public AccountDto save(AccountDto request) {
        Account account = accountMapper.toEntity(request);
        Account savedAccount = accountRepository.save(account);
        return accountMapper.toDto(savedAccount);
    }

    @Override
    public List<AccountDto> listAccounts() {
        return accountRepository.findAll().stream().map(accountMapper::toDto).collect(Collectors.toList());
    }
}
