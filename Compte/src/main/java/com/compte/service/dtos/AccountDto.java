package com.compte.service.dtos;

import com.compte.service.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {
    private String id;
    private Date createdAt;
    private double balance;
    private String currency;
    private AccountType accountType;
}
