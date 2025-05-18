package com.jarl.customer.interfaces.controller;

import com.jarl.customer.application.ClientCommand;
import com.jarl.customer.application.CreateClientUseCase;
import com.jarl.customer.application.DeleteClientUseCase;
import com.jarl.customer.application.UpdateClientUseCase;
import com.jarl.customer.domain.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClientController {
    private final CreateClientUseCase createClientUseCase;
    private final UpdateClientUseCase updateClientUseCase;
    private final DeleteClientUseCase deleteClientUseCase;

    public ClientController(CreateClientUseCase createClientUseCase, UpdateClientUseCase updateClientUseCase, DeleteClientUseCase deleteClientUseCase) {
        this.createClientUseCase = createClientUseCase;
        this.updateClientUseCase = updateClientUseCase;
        this.deleteClientUseCase = deleteClientUseCase;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ClientCommand command) {
        Client client = createClientUseCase.execute(command);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Cliente creado con ID: " + client.getClientId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody ClientCommand command) {
        Client client = updateClientUseCase.execute(id, command);
        return ResponseEntity.ok("Cliente creado con ID: " + client.getClientId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id) {
        deleteClientUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
