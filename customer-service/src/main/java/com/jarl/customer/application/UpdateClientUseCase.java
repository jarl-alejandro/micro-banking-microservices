package com.jarl.customer.application;

import com.jarl.customer.domain.Client;
import com.jarl.customer.domain.ClientNotFountException;
import com.jarl.customer.domain.ClientRepository;
import com.jarl.customer.domain.ClientService;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class UpdateClientUseCase {
    private final ClientRepository repository;
    private final ClientService service;

    public UpdateClientUseCase(ClientRepository repository) {
        this.repository = repository;
        this.service = new ClientService(repository);
    }

    public Client execute(String clientId, ClientCommand command) {
        return service.updateClient(
                UUID.fromString(clientId),
                command.getName(),
                command.getGender(),
                command.getAge(),
                command.getIdentification(),
                command.getDirection(),
                command.getPhone(),
                command.getPassword()
        );
    }
}
