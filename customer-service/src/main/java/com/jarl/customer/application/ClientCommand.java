package com.jarl.customer.application;

import com.jarl.customer.domain.Gender;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClientCommand {
    private final String name;
    private final Gender gender;
    private final int age;
    private final String identification;
    private final String direction;
    private final String phone;
    private final String password;
}
