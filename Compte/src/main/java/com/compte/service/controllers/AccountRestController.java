package com.compte.service.controllers;


import com.compte.service.dtos.AccountRequestDto;
import com.compte.service.dtos.AccountResponseDto;
import com.compte.service.services.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/accounts")
public class AccountRestController {
    private AccountService accountService;
    @GetMapping()
    public ResponseEntity<List<AccountResponseDto>> listAccounts(){
        return ResponseEntity.ok(accountService.listAccounts());
    }

    @PostMapping()
    public ResponseEntity<AccountResponseDto> save(@RequestBody AccountRequestDto accountRequestDto){
        return new ResponseEntity<>(accountService.save(accountRequestDto), HttpStatus.CREATED);
    }
}
