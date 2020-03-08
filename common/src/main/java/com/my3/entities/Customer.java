package com.my3.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @OneToOne
    private Account account;
    @OneToMany(fetch = FetchType.EAGER)
    private List<AddressDelivery> deliveries;
}
