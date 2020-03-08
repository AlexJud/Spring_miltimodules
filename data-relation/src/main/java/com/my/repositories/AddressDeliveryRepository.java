package com.my.repositories;

import com.my3.entities.AddressDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDeliveryRepository extends JpaRepository<AddressDelivery,Long> {
}
