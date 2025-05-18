package com.jarl.customer.infrastructure.repository.entity;

import com.jarl.customer.domain.Client;
import com.jarl.customer.domain.Gender;
import com.jarl.customer.domain.Phone;

import java.util.UUID;

public class ClientMapper {

    public static ClientEntity toEntity(Client domain) {
        PersonEntity person = new PersonEntity();
        person.setName(domain.getName());
        person.setGender(domain.getGender().name());
        person.setAge(domain.getAge());
        person.setIdentification(domain.getIdentification());
        person.setDirection(domain.getDirection());
        person.setPhone(domain.getPhone().value());

        ClientEntity client = new ClientEntity();
        client.setClientId(domain.getClientId().toString());
        client.setPassword(domain.getPassword());
        client.setState(domain.isState());
        client.setPerson(person);

        return client;
    }

    public static Client toDomain(ClientEntity entity) {
        PersonEntity p = entity.getPerson();
        return new Client(
                UUID.fromString(entity.getClientId()),
                p.getName(),
                Gender.valueOf(p.getGender()),
                p.getAge(),
                p.getIdentification(),
                p.getDirection(),
                new Phone(p.getPhone()),
                entity.getPassword(),
                entity.isState()
        );
    }
}
