package com.jarl.customer.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "clients")
public class ClientEntity {

    @Id
    @Column(nullable = false)
    private String clientId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean state;

    @OneToOne(optional = false)
    @JoinColumn(name = "persona_id", referencedColumnName = "persona_id")
    private PersonEntity person;

}
