package com.jarl.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class Person {
    protected String name;
    protected Gender gender;
    protected int age;
    protected String identification;
    protected String direction;
    protected Phone phone;

}
