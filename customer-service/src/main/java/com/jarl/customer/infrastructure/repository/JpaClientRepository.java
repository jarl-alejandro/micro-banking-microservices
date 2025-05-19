package com.jarl.customer.infrastructure.repository;

import com.jarl.customer.domain.Client;
import com.jarl.customer.domain.ClientRepository;
import com.jarl.customer.infrastructure.repository.entity.ClientJpaRepository;
import com.jarl.customer.infrastructure.repository.entity.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaClientRepository implements ClientRepository {

    private final ClientJpaRepository jpaRepository;

    @Override
    public Optional<Client> findByIdentification(String id) {
        return jpaRepository.findByPerson_Identification(id)
                .map(ClientMapper::toDomain);
    }

    @Override
    public Optional<Client> findById(String id) {
        return jpaRepository.findById(id)
                .map(ClientMapper::toDomain);
    }

    @Override
    public void save(Client client) {
        jpaRepository.save(ClientMapper.toEntity(client));
    }

    @Override
    public List<Client> list() {
        return jpaRepository.findAll().stream()
                .map(ClientMapper::toDomain)
                .toList();
    }


}
