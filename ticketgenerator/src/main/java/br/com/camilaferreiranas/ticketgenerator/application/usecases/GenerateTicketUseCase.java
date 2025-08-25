package br.com.camilaferreiranas.ticketgenerator.application.usecases;

import br.com.camilaferreiranas.ticketgenerator.interfaces.dtos.TicketRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class GenerateTicketUseCase {


    public void execute(TicketRequestDTO dto) {
        // validar usuario do github
        // salvar
        // manda email para fila e enviar e-mail de confirmação
    }
}
