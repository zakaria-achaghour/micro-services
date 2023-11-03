package com.compte.service.dtos;

import com.compte.service.enums.AccountType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    @NotNull
    private double balance;
    @NotEmpty
    private String currency;
    @NotEmpty
    private AccountType accountType;
}