package com.compte.service.dtos;

import com.compte.service.enums.AccountType;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

public class AccountRequestDto {
    @NotEmpty
    private String id;
    @NotEmpty
    private double balance;
    @NotEmpty
    private String currency;
    @NotEmpty
    private AccountType accountType;
}
