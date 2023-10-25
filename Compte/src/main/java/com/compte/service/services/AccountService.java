package com.compte.service.services;

import com.compte.service.dtos.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto save(AccountDto request);
    List<AccountDto> listAccounts();
}
