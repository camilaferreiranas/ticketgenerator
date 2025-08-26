package br.com.camilaferreiranas.ticketgenerator.application.usecases;

import br.com.camilaferreiranas.ticketgenerator.domain.builders.TicketBuilder;
import br.com.camilaferreiranas.ticketgenerator.domain.exception.UserNotFoundGithubException;
import br.com.camilaferreiranas.ticketgenerator.domain.model.Ticket;
import br.com.camilaferreiranas.ticketgenerator.domain.repository.EmailQueueRepository;
import br.com.camilaferreiranas.ticketgenerator.domain.repository.TicketRepository;
import br.com.camilaferreiranas.ticketgenerator.infrastructure.feign.GithubClient;
import br.com.camilaferreiranas.ticketgenerator.interfaces.dtos.GithubUserResponseDTO;
import br.com.camilaferreiranas.ticketgenerator.interfaces.dtos.TicketRequestDTO;
import br.com.camilaferreiranas.ticketgenerator.interfaces.dtos.TicketResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GenerateTicketUseCase {


    private final GithubClient githubClient;
    private final TicketRepository repository;
    private final EmailQueueRepository emailQueueRepository;


    public GenerateTicketUseCase(GithubClient githubClient, TicketRepository repository, EmailQueueRepository emailQueueRepository) {
        this.githubClient = githubClient;
        this.repository = repository;
        this.emailQueueRepository = emailQueueRepository;
    }

    public TicketResponseDTO execute(TicketRequestDTO dto) {

        GithubUserResponseDTO githubResponse = githubClient.getUser(dto.githubProfile());


        if (githubResponse.login() != null) { //mudar
            Ticket ticket = new TicketBuilder()
                    .name(dto.name()).githubProfile(dto.githubProfile()).conference(dto.conference())
                    .email(dto.email())
                    .urlImage(dto.urlImage())
                    .date(LocalDate.now().plusMonths(3))
                    .build();

            var ticketSaved = repository.save(ticket);
            emailQueueRepository.send(ticketSaved.getEmail());
            return new TicketResponseDTO(ticketSaved.getName(), ticketSaved.getgithubProfile(), ticketSaved.getUrlImage(), ticketSaved.getEmail());
        } else {
            throw new UserNotFoundGithubException("Usuário não existe no Github");
        }
        // validar usuario do github
        // salvar
        // manda email para fila e enviar e-mail de confirmação
    }
}
