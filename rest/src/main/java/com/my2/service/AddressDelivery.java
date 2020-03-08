package com.my2.service;
import java.util.List;
import java.util.Optional;

public interface AddressDelivery {
    AddressDelivery save(AddressDelivery addressDelivery);
    void delete(AddressDelivery addressDelivery);
    Optional<AddressDelivery> findById(Long id);
    List<AddressDelivery> getAll();
}
