package com.my2.service;


import com.my3.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer save(Customer customer);
    void delete(Customer customer);
    Optional<Customer> findById(Long id);
    List<Customer> getAll();
}
