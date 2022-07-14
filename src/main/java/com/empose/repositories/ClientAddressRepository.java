package com.empose.repositories;

import com.empose.models.ClientAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientAddressRepository extends JpaRepository<ClientAddress, Integer> {


}