package com.jarl.customer.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "clients")
public class ClientEntity {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "client_id", columnDefinition = "CHAR(36)")
    private UUID clientId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean state;

    @OneToOne(optional = false)
    @JoinColumn(name = "persona_id", referencedColumnName = "identification")
    private PersonEntity person;

}
