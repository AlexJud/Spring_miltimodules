package com.my2.service;

import java.util.List;
import java.util.Optional;

public interface Account {
    Account save(Account account);
    void delete(Account account);
    Optional<Account> findById(Long id);
    List<Account> getAdd();
}
