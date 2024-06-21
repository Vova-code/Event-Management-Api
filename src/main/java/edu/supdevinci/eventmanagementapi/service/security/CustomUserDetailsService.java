package edu.supdevinci.eventmanagementapi.service.security;

import edu.supdevinci.eventmanagementapi.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<edu.supdevinci.eventmanagementapi.model.database.User> user = userRepository.findByEmail(username);
        if(user.isPresent()) {
            return User.builder()
                    .username(user.get().getEmail())
                    .password(user.get().getPassword())
                    .roles("USER")
                    .build();
        }

        if(userRepository.count() == 0) {
            return User.builder()
                    .username("jon@doe.fr")
                    .password("jondoe")
                    .authorities("USER")
                    .build();
        }

        throw new UsernameNotFoundException("User not found");
    }
}
