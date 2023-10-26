package com.compte.service.dtos;

import com.compte.service.enums.AccountType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountResponseDto {
    private String id;
    private Date createdAt;
    private double balance;
    private String currency;
    private AccountType accountType;
}
