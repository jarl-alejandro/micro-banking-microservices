package com.jarl.customer.domain;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    Optional<Client> findByIdentification(String id);
    Optional<Client> findById(String id);
    void save(Client client);

    List<Client> list();

}
