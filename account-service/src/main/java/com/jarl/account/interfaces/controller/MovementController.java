package com.jarl.account.interfaces.controller;

import com.jarl.account.application.GenerateReportUseCase;
import com.jarl.account.application.MovementCommand;
import com.jarl.account.application.RegisterMovementUseCase;
import com.jarl.account.domain.Movement;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movements")
public class MovementController {

    private final RegisterMovementUseCase registerMovementUseCase;
    private final GenerateReportUseCase generateReportUseCase;

    public MovementController(RegisterMovementUseCase registerMovementUseCase,
                              GenerateReportUseCase generateReportUseCase) {
        this.registerMovementUseCase = registerMovementUseCase;
        this.generateReportUseCase = generateReportUseCase;
    }

    @PostMapping
    public ResponseEntity<String> registerMovement(@RequestBody MovementCommand command) {
        registerMovementUseCase.execute(
                command.accountNumber(),
                command.amount(),
                command.type()
        );
        return ResponseEntity.ok("Movement registered successfully");
    }

    @GetMapping("/report")
    public ResponseEntity<List<Movement>> getReport(
            @RequestParam String accountNumber,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {

        List<Movement> report = generateReportUseCase.execute(accountNumber, from, to);
        return ResponseEntity.ok(report);
    }
}
