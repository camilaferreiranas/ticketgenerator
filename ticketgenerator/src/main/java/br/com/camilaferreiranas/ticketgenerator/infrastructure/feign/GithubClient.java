package br.com.camilaferreiranas.ticketgenerator.infrastructure.feign;

import br.com.camilaferreiranas.ticketgenerator.interfaces.dtos.GithubUserResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "githubclient", url = "https://api.github.com")
public interface GithubClient {

    @GetMapping("/users/{username}")
    GithubUserResponseDTO getUser(@PathVariable("username") String username);
}
