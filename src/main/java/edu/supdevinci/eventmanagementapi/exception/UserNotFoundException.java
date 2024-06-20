package edu.supdevinci.eventmanagementapi.exception;

public class UserNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Utilisateur introuvable";

    public UserNotFoundException() {
        super(MESSAGE);
    }
}
