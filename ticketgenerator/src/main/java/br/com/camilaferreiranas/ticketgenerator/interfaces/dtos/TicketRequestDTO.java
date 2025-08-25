package br.com.camilaferreiranas.ticketgenerator.interfaces.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record TicketRequestDTO(@NotBlank(message = "Nome não pode ser nulo") String name,
                               @NotBlank(message = "Perfil do Github é obrigatório") String githubProfile,
                               String urlImage, String conference,
                               @NotBlank(message = "E-mail não pode ser vazio") @Email String email) {
}
