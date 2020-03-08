package com.my4.controllers;

import com.my.repositories.CustomerRepository;
import com.my3.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class CustomerFluxController {

    @Autowired
    private CustomerRepository customerRepository;

    @Bean
    public RouterFunction<ServerResponse> customerRouter() {
        return
                route(
                        GET("/customer"),
                        req -> ok().body(Flux.fromIterable(customerRepository.findAll()), Customer.class)
                ).and(route(
                        GET("/customer/{id}"),
                        req -> ok().body(Mono.just(customerRepository.findById(
                                Long.parseLong(req.pathVariable("id")))
                        ), Customer.class)
                        ).and(route(
                        POST("/customer"),
                        req -> req.bodyToMono(Customer.class)
                                .doOnNext(customerRepository::save)
                                .then(ok().build())
                        ))
                );
    }
}
