package com.jarl.customer.application;

import com.jarl.customer.domain.Client;
import com.jarl.customer.domain.ClientNotFountException;
import com.jarl.customer.domain.ClientRepository;
import com.jarl.customer.domain.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class DeleteClientUseCase {
    private final ClientRepository repository;

    public void execute(String clientId) {
        Client client = repository.findById(clientId)
                .orElseThrow(() -> new ClientNotFountException(clientId));

        client.disable();
        repository.save(client);
    }
}
