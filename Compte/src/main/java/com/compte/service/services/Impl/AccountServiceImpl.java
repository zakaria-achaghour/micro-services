package com.compte.service.services.Impl;

import com.compte.service.dtos.AccountRequestDto;
import com.compte.service.dtos.AccountResponseDto;
import com.compte.service.exceptions.AccountNotFoundException;
import com.compte.service.mappers.AccountMapper;
import com.compte.service.models.Account;
import com.compte.service.repositories.AccountRepository;
import com.compte.service.services.AccountService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service @Transactional
@AllArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private AccountMapper accountMapper;
    @Override
    public AccountResponseDto save(AccountRequestDto request) {
        Account account = accountMapper.toEntity(request);
        account.setId(UUID.randomUUID().toString());
        account.setCreatedAt(new Date());
        Account savedAccount = accountRepository.save(account);
        return accountMapper.toDto(savedAccount);
    }

    @Override
    public List<AccountResponseDto> listAccounts() {
        return accountRepository.findAll().stream().map(accountMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public AccountResponseDto getAccountById(String id) throws AccountNotFoundException {
        Account account = accountRepository.findById(id).orElse(null);
        if (account==null) throw new AccountNotFoundException(String.format("Account Not Found with id :%s",id));
        return accountMapper.toDto(account);
    }

    @Override
    public AccountResponseDto update(AccountRequestDto requestDTO, String id) throws AccountNotFoundException {
        Account account = accountRepository.findById(id).orElse(null);
        if (account==null) throw new AccountNotFoundException(String.format("Account Not Found with id :%s", id));
        account.setBalance(requestDTO.getBalance());
        if(requestDTO.getCurrency() != null) account.setCurrency(requestDTO.getCurrency());
        if(requestDTO.getAccountType() != null) account.setAccountType(requestDTO.getAccountType());
        Account savedAccount = accountRepository.save(account);
        return accountMapper.toDto(savedAccount);
    }

    @Override
    public void deleteAccount(String id) throws AccountNotFoundException {
        Account account = accountRepository.findById(id).orElse(null);
        if (account==null) throw new AccountNotFoundException(String.format("Account Not Found with id :%s",id));
        accountRepository.deleteById(id);
    }
}
