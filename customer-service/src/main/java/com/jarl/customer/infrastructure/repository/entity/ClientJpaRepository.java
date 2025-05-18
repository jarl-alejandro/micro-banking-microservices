package com.jarl.customer.infrastructure.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientJpaRepository  extends JpaRepository<ClientEntity, String> {
    Optional<ClientEntity> findByPerson_Identification(String identification);

}
