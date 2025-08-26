package br.com.camilaferreiranas.ticketgenerator.infrastructure.mapper;

import br.com.camilaferreiranas.ticketgenerator.domain.model.Ticket;
import br.com.camilaferreiranas.ticketgenerator.infrastructure.persistence.TicketEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    Ticket toDomain(TicketEntity ticket);
    TicketEntity toEntity(Ticket ticket);
}
