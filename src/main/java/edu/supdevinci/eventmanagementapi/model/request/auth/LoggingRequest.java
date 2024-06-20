package edu.supdevinci.eventmanagementapi.model.request.auth;

import jakarta.validation.constraints.NotEmpty;

public record LoggingRequest(
        @NotEmpty(message = "L'email ne peut pas être null") String email,
        @NotEmpty(message = "Le mot de passe ne peut pas être null") String password
) {
}
