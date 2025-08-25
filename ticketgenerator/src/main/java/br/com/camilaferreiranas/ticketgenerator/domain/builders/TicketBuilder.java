package br.com.camilaferreiranas.ticketgenerator.domain.builders;

import br.com.camilaferreiranas.ticketgenerator.domain.model.Ticket;

import java.time.LocalDate;
import java.util.UUID;

public class TicketBuilder implements ITicketBuilder{

    private UUID id;
    private String name;
    private LocalDate date;
    private String githubProfile;
    private String urlImage;
    private String conference;
    private String email;


    @Override
    public ITicketBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    @Override
    public ITicketBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ITicketBuilder date(LocalDate date) {
        this.date = date;
        return this;
    }

    @Override
    public ITicketBuilder githubProfile(String githubProfile) {
        this.githubProfile = githubProfile;
        return this;
    }

    @Override
    public ITicketBuilder urlImage(String urlImage) {
        this.urlImage = urlImage;
        return this;
    }

    @Override
    public ITicketBuilder conference(String conference) {
        this.conference = conference;
        return this;
    }

    @Override
    public ITicketBuilder email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public Ticket build() {
        return new Ticket(id, name, date, githubProfile, urlImage, conference, email);
    }


}
