package com.my4.controllers;

import com.my.repositories.AccountRepository;
import com.my3.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public Flux<Account> getAll() {
        return Flux.fromIterable(accountRepository.findAll());
    }

    @GetMapping("/{id}")
    public Mono<Account> getById(@PathVariable Long id) {
        return Mono.justOrEmpty(accountRepository.findById(id));
    }

    @PostMapping
    public Mono<Account> save(@RequestBody Account account){
        return Mono.justOrEmpty(accountRepository.save(account));
    }

}
