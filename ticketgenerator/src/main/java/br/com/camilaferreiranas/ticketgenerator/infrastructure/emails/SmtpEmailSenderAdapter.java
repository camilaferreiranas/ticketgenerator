package br.com.camilaferreiranas.ticketgenerator.infrastructure.emails;

import br.com.camilaferreiranas.ticketgenerator.domain.repository.EmailSenderRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SmtpEmailSenderAdapter implements EmailSenderRepository {

    private final JavaMailSender mailSender;

    public SmtpEmailSenderAdapter(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void send(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Confirmação de participação");
        message.setText("Sua participação foi confirmada");
        mailSender.send(message);
    }
}
