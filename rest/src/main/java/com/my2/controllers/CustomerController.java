package com.my2.controllers;

import com.my.repositories.CustomerRepository;
import com.my3.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        return ResponseEntity.of(customerRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Customer customer){
        return ResponseEntity.ok(customerRepository.save(customer));
    }
}
