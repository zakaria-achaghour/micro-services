package com.compte.service.mappers;

import com.compte.service.dtos.AccountRequestDto;
import com.compte.service.dtos.AccountResponseDto;
import com.compte.service.models.Account;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AccountMapper {
    private ModelMapper modelMapper=new ModelMapper();
    public AccountResponseDto toDto(Account account){
        return modelMapper.map(account, AccountResponseDto.class);
    }
    public Account toEntity(AccountRequestDto accountDto){
        return modelMapper.map(accountDto,Account.class);
    }
}
