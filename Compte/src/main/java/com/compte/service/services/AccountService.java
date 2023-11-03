package com.compte.service.services;

import com.compte.service.dtos.AccountRequestDto;
import com.compte.service.dtos.AccountResponseDto;
import com.compte.service.exceptions.AccountNotFoundException;

import java.util.List;

public interface AccountService {

    AccountResponseDto save(AccountRequestDto request);
    List<AccountResponseDto> listAccounts();
    AccountResponseDto getAccountById(String id) throws AccountNotFoundException;
    AccountResponseDto update(AccountRequestDto requestDTO, String id) throws AccountNotFoundException;
    void deleteAccount(String id) throws AccountNotFoundException;
}
