package br.com.camilaferreiranas.ticketgenerator.application.usecases;

import br.com.camilaferreiranas.ticketgenerator.domain.repository.TicketRepository;
import br.com.camilaferreiranas.ticketgenerator.interfaces.dtos.TicketResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllTicketUseCase {

    private final TicketRepository repository;

    public ListAllTicketUseCase(TicketRepository repository) {
        this.repository = repository;
    }


    public List<TicketResponseDTO> execute() {
        return repository.findAll().stream().map(ticket -> new TicketResponseDTO(ticket.getName(),
                ticket.getgithubProfile(), ticket.getUrlImage(), ticket.getEmail())).toList();
    }
}
