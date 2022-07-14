package com.empose.repositories;

import com.empose.models.Sku;
import com.empose.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByName(String name);
}