package com.jarl.customer.application;

import com.jarl.customer.domain.Client;
import com.jarl.customer.domain.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ListClientsUseCase {
    private final ClientRepository repository;

    public List<Client> execute() {
        return repository.list();
    }


}
