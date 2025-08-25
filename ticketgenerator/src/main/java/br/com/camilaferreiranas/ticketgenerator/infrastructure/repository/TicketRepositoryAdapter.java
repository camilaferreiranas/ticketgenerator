package br.com.camilaferreiranas.ticketgenerator.infrastructure.repository;

import br.com.camilaferreiranas.ticketgenerator.domain.model.Ticket;
import br.com.camilaferreiranas.ticketgenerator.domain.repository.TicketRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketRepositoryAdapter implements TicketRepository {

    private final TicketRepositoryJpa repositoryJpa;

    public TicketRepositoryAdapter(TicketRepositoryJpa repositoryJpa) {
        this.repositoryJpa = repositoryJpa;
    }

    @Override
    public void save(Ticket ticket) {

    }

    @Override
    public List<Ticket> findAll() {
        return List.of();
    }
}
