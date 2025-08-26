package br.com.camilaferreiranas.ticketgenerator;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@EnableRabbit
public class TicketgeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketgeneratorApplication.class, args);
	}

}
