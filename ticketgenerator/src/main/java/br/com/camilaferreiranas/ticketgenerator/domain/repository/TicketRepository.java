package br.com.camilaferreiranas.ticketgenerator.domain.repository;

import br.com.camilaferreiranas.ticketgenerator.domain.model.Ticket;

import java.util.List;

public interface TicketRepository {

    void save(Ticket ticket);
    List<Ticket> findAll();
}
