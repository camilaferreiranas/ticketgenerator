package br.com.camilaferreiranas.ticketgenerator.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerException {


    @ExceptionHandler(UserNotFoundGithubException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFoundGithub(UserNotFoundGithubException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Usuário não encontrado no Github" );
        body.put("message", e.getMessage() );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
