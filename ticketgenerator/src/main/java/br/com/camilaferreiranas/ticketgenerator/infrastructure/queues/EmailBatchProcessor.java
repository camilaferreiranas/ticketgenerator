package br.com.camilaferreiranas.ticketgenerator.infrastructure.queues;

import br.com.camilaferreiranas.ticketgenerator.domain.repository.EmailSenderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmailBatchProcessor {

    private static final Logger log = LoggerFactory.getLogger(EmailBatchProcessor.class);
    private final RedisTemplate<String, String> redisTemplate;
    private final EmailSenderRepository repository;
    private static final String QUEUE_KEY = "emails:lote";


    public EmailBatchProcessor(RedisTemplate<String, String> redisTemplate, EmailSenderRepository repository) {
        this.redisTemplate = redisTemplate;
        this.repository = repository;
    }

    @Scheduled(fixedRate = 180000)
    public void processarLoteEmails() {
        List<String> lote = new ArrayList<>();
        String email;
        while ((email = redisTemplate.opsForList().rightPop(QUEUE_KEY)) != null) {
            lote.add(email);
        }

        if(!lote.isEmpty()) {
            log.info("Processando e enviando lote: {}", lote.size());
            lote.forEach(repository::send);
        }
    }
}
