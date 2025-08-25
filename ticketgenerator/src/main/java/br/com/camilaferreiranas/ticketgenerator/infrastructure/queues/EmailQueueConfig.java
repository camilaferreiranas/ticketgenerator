package br.com.camilaferreiranas.ticketgenerator.infrastructure.queues;

import br.com.camilaferreiranas.ticketgenerator.domain.repository.EmailQueueRepository;
import br.com.camilaferreiranas.ticketgenerator.infrastructure.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@Component
public class EmailQueueConfig implements EmailQueueRepository {

    private final RabbitTemplate rabbitTemplate;

    public EmailQueueConfig(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void send(String email) {
        rabbitTemplate.convertAndSend(RabbitConfig.EMAIL_QUEUE, email);
    }
}
