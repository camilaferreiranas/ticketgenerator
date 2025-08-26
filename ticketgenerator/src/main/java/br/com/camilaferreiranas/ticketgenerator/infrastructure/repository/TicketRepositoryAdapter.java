package br.com.camilaferreiranas.ticketgenerator.infrastructure.repository;

import br.com.camilaferreiranas.ticketgenerator.domain.model.Ticket;
import br.com.camilaferreiranas.ticketgenerator.domain.repository.TicketRepository;
import br.com.camilaferreiranas.ticketgenerator.infrastructure.mapper.TicketMapper;
import br.com.camilaferreiranas.ticketgenerator.infrastructure.persistence.TicketEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketRepositoryAdapter implements TicketRepository {

    private final TicketRepositoryJpa repositoryJpa;
    private final TicketMapper mapper;

    public TicketRepositoryAdapter(TicketRepositoryJpa repositoryJpa, TicketMapper mapper) {
        this.repositoryJpa = repositoryJpa;
        this.mapper = mapper;
    }

    @Override
    public Ticket save(Ticket ticket) {
        TicketEntity ticketToSave = mapper.toEntity(ticket);
        var ticketEntity = repositoryJpa.save(ticketToSave);
        return mapper.toDomain(ticketEntity);

    }

    @Override
    public List<Ticket> findAll() {
        return repositoryJpa.findAll().stream().map(mapper::toDomain).toList();
    }
}
