package br.com.camilaferreiranas.ticketgenerator.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "ticket")
@Data
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private LocalDate date;
    private String githubProfile;
    private String urlImage;
    private String conference;
    private String email;
}
