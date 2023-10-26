package com.compte.service.services;

import com.compte.service.dtos.AccountRequestDto;
import com.compte.service.dtos.AccountResponseDto;

import java.util.List;

public interface AccountService {

    AccountResponseDto save(AccountRequestDto request);
    List<AccountResponseDto> listAccounts();
}
