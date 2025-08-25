package br.com.camilaferreiranas.ticketgenerator.infrastructure.repository;

import br.com.camilaferreiranas.ticketgenerator.infrastructure.persistence.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketRepositoryJpa extends JpaRepository<TicketEntity, UUID> {
}
