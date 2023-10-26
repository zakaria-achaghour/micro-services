package com.compte.service.dtos;

import com.compte.service.enums.AccountType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
