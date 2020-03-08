package com.my2.controllers;

import com.my.repositories.AccountRepository;
import com.my3.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(accountRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        return ResponseEntity.of(accountRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Account account) {
        return ResponseEntity.ok(accountRepository.save(account));
    }


}
