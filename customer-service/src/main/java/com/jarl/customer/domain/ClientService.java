package com.jarl.customer.domain;

import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static com.jarl.customer.common.Validations.validateNonNull;

@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository repository;

    public Client createClient(String name, Gender gender, int age, String identification, String direction, String phone, String password) {
        validateNonNull("nombre", name);
        validateNonNull("gender", gender);
        validateNonNull("age", age);
        validateNonNull("identification", identification);
        validateNonNull("direction", direction);
        validateNonNull("phone", phone);
        validateNonNull("password", password);

        if (repository.findByIdentification(identification).isPresent()) {
            throw new DuplicateClientException(identification);
        }

        Client client = new Client(UUID.randomUUID(),
                name,
                gender,
                age,
                identification,
                direction,
                new Phone(phone),
                password,
                Boolean.TRUE);

        repository.save(client);

        return client;
    }

    public Client updateClient(UUID clientId,
                               String name,
                               Gender gender,
                               int age,
                               String identification,
                               String direction,
                               String phone,
                               String password) {

        validateNonNull("client id", clientId);
        validateNonNull("nombre", name);
        validateNonNull("gender", gender);
        validateNonNull("age", age);
        validateNonNull("identification", identification);
        validateNonNull("direction", direction);
        validateNonNull("phone", phone);
        validateNonNull("password", password);

        Client client = repository.findById(clientId.toString())
                .orElseThrow(() -> new ClientNotFountException(clientId.toString()));

        Optional<Client> byIdentification = repository.findByIdentification(identification);

        if (byIdentification.isPresent() &&
                Objects.equals(byIdentification.get().getClientId(), client.getClientId())) {
            throw new DuplicateClientException(identification);
        }

        client.update(
                name,
                gender,
                age,
                identification,
                direction,
                new Phone(phone),
                password
        );

        repository.save(client);
        return client;
    }
}
