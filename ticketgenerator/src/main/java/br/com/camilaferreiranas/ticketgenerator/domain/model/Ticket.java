package br.com.camilaferreiranas.ticketgenerator.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public class Ticket {

    private UUID id;
    private String name;
    private LocalDate date;
    private String githubProfile;
    private String urlImage;
    private String conference;
    private String email;

    public Ticket() {
    }

    public Ticket(UUID id, String name, LocalDate date, String githubProfile, String urlImage, String conference, String email) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.githubProfile = githubProfile;
        this.urlImage = urlImage;
        this.conference = conference;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getgithubProfile() {
        return githubProfile;
    }

    public void setgithubProfile(String githubProfile) {
        this.githubProfile = githubProfile;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getconference() {
        return conference;
    }

    public void setconference(String conference) {
        this.conference = conference;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
