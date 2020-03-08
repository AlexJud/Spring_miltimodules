package com.my4.controllers;

import com.my.repositories.AddressDeliveryRepository;
import com.my3.entities.AddressDelivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/address")
public class AddressDeliveryController {

    @Autowired
    private AddressDeliveryRepository addressDeliveryRepository;

    @GetMapping
    public Flux<AddressDelivery> getAll(){
        return Flux.fromIterable(addressDeliveryRepository.findAll());
    }

    @GetMapping("/{id}")
    public Mono<AddressDelivery> getById(@PathVariable Long id){
        return Mono.justOrEmpty(addressDeliveryRepository.findById(id));
    }

    @PostMapping
    public Mono<AddressDelivery> save(@RequestBody AddressDelivery addressDelivery){
        return Mono.justOrEmpty(addressDeliveryRepository.save(addressDelivery));
    }
}
