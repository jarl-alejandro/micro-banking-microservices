package com.jarl.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Client extends Person {

    private final UUID clientId;
    private String password;
    private boolean state;

    public Client(UUID clientId, String name, Gender gender, int age, String identification, String direction, Phone phone, String password, boolean state) {
        super(name, gender, age, identification, direction, phone);
        this.password = password;
        this.clientId = clientId;
        this.state = state;
    }

    public void disable() {
        this.state = false;
    }

    public void update(String name, Gender gender, int age, String identification, String direction, Phone phone, String password) {
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.identification = identification;
        this.direction = direction;
        this.phone = phone;
    }
}
