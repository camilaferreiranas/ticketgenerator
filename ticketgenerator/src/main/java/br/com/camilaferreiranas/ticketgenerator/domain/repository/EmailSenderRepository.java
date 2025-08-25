package br.com.camilaferreiranas.ticketgenerator.domain.repository;

public interface EmailSenderRepository {

    void send(String email);
}
