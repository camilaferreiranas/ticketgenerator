package br.com.camilaferreiranas.ticketgenerator.interfaces.controllers;

import br.com.camilaferreiranas.ticketgenerator.application.usecases.GenerateTicketUseCase;
import br.com.camilaferreiranas.ticketgenerator.application.usecases.ListAllTicketUseCase;
import br.com.camilaferreiranas.ticketgenerator.interfaces.dtos.TicketRequestDTO;
import br.com.camilaferreiranas.ticketgenerator.interfaces.dtos.TicketResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ticket")
public class TicketController {


    private final GenerateTicketUseCase generateTicketUseCase;
    private final ListAllTicketUseCase listAllTicketUseCase;

    public TicketController(GenerateTicketUseCase generateTicketUseCase, ListAllTicketUseCase listAllTicketUseCase) {
        this.generateTicketUseCase = generateTicketUseCase;
        this.listAllTicketUseCase = listAllTicketUseCase;
    }

    @PostMapping
    public ResponseEntity<TicketResponseDTO> save(@Valid @RequestBody TicketRequestDTO dto) {

        return ResponseEntity.ok(generateTicketUseCase.execute(dto));
    }

    @GetMapping
    public ResponseEntity<List<TicketResponseDTO>> listAll() {
        return ResponseEntity.ok(listAllTicketUseCase.execute());
    }
}
