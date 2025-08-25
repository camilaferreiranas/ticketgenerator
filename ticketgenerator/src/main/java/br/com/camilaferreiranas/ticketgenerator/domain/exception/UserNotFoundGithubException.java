package br.com.camilaferreiranas.ticketgenerator.domain.exception;

public class UserNotFoundGithubException extends RuntimeException {
    public UserNotFoundGithubException(String message) {
        super(message);
    }

    public UserNotFoundGithubException(String message, Throwable cause) {
        super(message, cause);
    }
}
