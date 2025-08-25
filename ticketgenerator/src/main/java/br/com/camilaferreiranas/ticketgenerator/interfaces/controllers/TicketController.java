package br.com.camilaferreiranas.ticketgenerator.interfaces.controllers;

import br.com.camilaferreiranas.ticketgenerator.application.usecases.GenerateTicketUseCase;
import br.com.camilaferreiranas.ticketgenerator.interfaces.dtos.TicketRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ticket")
public class TicketController {


    private final GenerateTicketUseCase generateTicketUseCase;

    public TicketController(GenerateTicketUseCase generateTicketUseCase) {
        this.generateTicketUseCase = generateTicketUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TicketRequestDTO dto) {
        generateTicketUseCase.execute(dto);
        return ResponseEntity.ok().build();
    }
}
