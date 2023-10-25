package com.compte.service.mappers;

import com.compte.service.dtos.AccountDto;
import com.compte.service.models.Account;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AccountMapper {
    private ModelMapper modelMapper=new ModelMapper();
    public AccountDto toDto(Account account){
        return modelMapper.map(account,AccountDto.class);
    }
    public Account toEntity(AccountDto accountDto){
        return modelMapper.map(accountDto,Account.class);
    }
}
