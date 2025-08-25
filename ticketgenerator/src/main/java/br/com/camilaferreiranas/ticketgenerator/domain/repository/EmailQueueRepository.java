package br.com.camilaferreiranas.ticketgenerator.domain.repository;

public interface EmailQueueRepository {

    void send(String email);
}
