package com.my2.controllers;

import com.my.repositories.AddressDeliveryRepository;
import com.my3.entities.AddressDelivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressDeliveryController {

    @Autowired
    private AddressDeliveryRepository addressDeliveryRepository;

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(addressDeliveryRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        return ResponseEntity.of(addressDeliveryRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody AddressDelivery addressDelivery){
        return ResponseEntity.ok(addressDeliveryRepository.save(addressDelivery));
    }

}
