package com.jarl.customer.application;

import com.jarl.customer.domain.Client;
import com.jarl.customer.domain.ClientRepository;
import com.jarl.customer.domain.ClientService;
import org.springframework.stereotype.Component;

@Component
public class CreateClientUseCase {
    private final ClientService service ;

    public CreateClientUseCase(ClientRepository repository) {
        this.service = new ClientService(repository);
    }

    public Client execute(ClientCommand command) {
        return service.createClient(
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
