package com.jarl.customer.infrastructure.repository.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "persons")
public class PersonEntity {

    @Id
    @Column(nullable = false, unique = true)
    private String identification;

    @Column(nullable = false)
    private String name;

    @Column
    private String gender;

    @Column
    private Integer age;

    @Column
    private String direction;

    @Column
    private String phone;
}
