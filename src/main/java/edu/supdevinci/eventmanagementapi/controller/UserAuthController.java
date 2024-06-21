package edu.supdevinci.eventmanagementapi.controller;

import edu.supdevinci.eventmanagementapi.model.request.auth.LoggingRequest;
import edu.supdevinci.eventmanagementapi.model.request.auth.SignupRequest;
import edu.supdevinci.eventmanagementapi.service.user.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class UserAuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public UserAuthController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoggingRequest request, HttpServletResponse response) {
        if (userService.existsByEmail(request.email())) {
            authenticateUser(response, request.email(), request.password());

            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignupRequest signupRequest, HttpServletResponse response) {
        var user = userService.register(signupRequest);

        authenticateUser(response, user.getEmail(), signupRequest.password());

        return ResponseEntity.ok().build();
    }

    private void authenticateUser(HttpServletResponse response, String email, String password) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        setCookie(response);
    }

    private static void setCookie(HttpServletResponse response) {
        var auth = new Cookie("auth", UUID.randomUUID().toString());
        auth.setMaxAge(60 * 60);
        response.addCookie(auth);
    }
}
