package br.com.camilaferreiranas.ticketgenerator.domain.builders;

import br.com.camilaferreiranas.ticketgenerator.domain.model.Ticket;

import java.time.LocalDate;
import java.util.UUID;

public interface ITicketBuilder {

    ITicketBuilder id(UUID id);
    ITicketBuilder name(String name);
    ITicketBuilder date(LocalDate date);
    ITicketBuilder githubProfile(String githubProfile);
    ITicketBuilder urlImage(String urlImage);
    ITicketBuilder conference(String conference);
    ITicketBuilder email(String email);
    Ticket build();
}
