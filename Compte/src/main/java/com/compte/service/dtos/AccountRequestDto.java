package com.compte.service.dtos;

import com.compte.service.enums.AccountType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRequestDto {
    @NotEmpty
    private String id;
    @NotNull
    private double balance;
    @NotEmpty
    private String currency;
    @NotEmpty
    private AccountType accountType;
}
