package br.com.camilaferreiranas.ticketgenerator.infrastructure.queues;

import br.com.camilaferreiranas.ticketgenerator.domain.repository.EmailSenderRepository;
import br.com.camilaferreiranas.ticketgenerator.infrastructure.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class EmailQueueConsumer {

    private final EmailSenderRepository repository;

    public EmailQueueConsumer(EmailSenderRepository repository) {
        this.repository = repository;
    }


    @RabbitListener(queues = RabbitConfig.EMAIL_QUEUE)
    public void receiveMessage(String email) {
        repository.send(email);
    }
}
