package com.jarl.account.interfaces.controller;

import com.jarl.account.application.*;
import com.jarl.account.domain.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final ListAccountsUseCase listAccountsUseCase;
    private final CreateAccountUseCase createAccountUseCase;
    private final DeleteAccountUseCase deleteAccountUseCase;
    private final UpdateAccountUseCase updateAccountUseCase;

    public AccountController(ListAccountsUseCase listAccountsUseCase, CreateAccountUseCase createAccountUseCase, DeleteAccountUseCase deleteAccountUseCase, UpdateAccountUseCase updateAccountUseCase) {
        this.listAccountsUseCase = listAccountsUseCase;
        this.createAccountUseCase = createAccountUseCase;
        this.deleteAccountUseCase = deleteAccountUseCase;
        this.updateAccountUseCase = updateAccountUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Account>> list() {
        return ResponseEntity.ok(listAccountsUseCase.execute());
    }


    @PostMapping
    public ResponseEntity<Void> createAccount(@RequestBody AccountCommand command) {
        createAccountUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{accountNumber}")
    public ResponseEntity<Void> updateAccount(@PathVariable String accountNumber, @RequestBody AccountCommand command) {
        updateAccountUseCase.execute(accountNumber, command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{accountNumber}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String accountNumber) {
        deleteAccountUseCase.execute(accountNumber);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

