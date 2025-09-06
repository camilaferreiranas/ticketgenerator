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
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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


        try {
            GithubUserResponseDTO githubResponse = githubClient.getUser(dto.githubProfile());


            Ticket ticket = new TicketBuilder()
                    .name(dto.name()).githubProfile(dto.githubProfile()).conference(dto.conference())
                    .email(dto.email())
                    .urlImage(dto.urlImage())
                    .date(LocalDate.now().plusMonths(3))
                    .build();

            var ticketSaved = repository.save(ticket);
            emailQueueRepository.send(ticketSaved.getEmail());
            return new TicketResponseDTO(ticketSaved.getName(), ticketSaved.getgithubProfile(), ticketSaved.getUrlImage(), ticketSaved.getEmail());
        } catch (FeignException.NotFound e) {
            throw new UserNotFoundGithubException("Usuário não existe no Github");
        }

    }
}
