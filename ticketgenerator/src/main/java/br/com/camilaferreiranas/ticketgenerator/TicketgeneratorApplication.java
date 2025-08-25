package br.com.camilaferreiranas.ticketgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TicketgeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketgeneratorApplication.class, args);
	}

}
