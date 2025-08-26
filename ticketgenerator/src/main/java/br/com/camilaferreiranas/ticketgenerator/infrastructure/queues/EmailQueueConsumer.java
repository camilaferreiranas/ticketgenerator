package br.com.camilaferreiranas.ticketgenerator.infrastructure.queues;

import br.com.camilaferreiranas.ticketgenerator.infrastructure.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmailQueueConsumer {


    private static final Logger log = LoggerFactory.getLogger(EmailQueueConsumer.class);
    private final RedisTemplate<String, String> redisTemplate;
    private static final String QUEUE_KEY = "emails:lote";

    public EmailQueueConsumer(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @RabbitListener(queues = RabbitConfig.EMAIL_QUEUE)
    public void receiveMessage(String email) {
        log.info("Salvando no Redis: {}", email);
        redisTemplate.opsForList().leftPush(QUEUE_KEY, email);
    }
}
