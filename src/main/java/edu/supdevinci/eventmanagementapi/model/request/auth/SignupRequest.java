package edu.supdevinci.eventmanagementapi.model.request.auth;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record SignupRequest(
        @NotEmpty(message = "The email can not be empty") String email,
        @NotEmpty(message = "The password can not be empty") String password,
        @NotEmpty(message = "The city can not be empty") String city,
        @Min(value = 18, message = "You have to be at least 18 years old")
        @Max(value = 99, message = "Sorry, its becoming too dangerous for you to apply to this application")
        int age,
        String description
) {
}
