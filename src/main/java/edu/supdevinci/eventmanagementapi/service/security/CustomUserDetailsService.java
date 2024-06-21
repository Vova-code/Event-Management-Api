package edu.supdevinci.eventmanagementapi.service.security;

<<<<<<< HEAD
=======
import edu.supdevinci.eventmanagementapi.exception.UserNotFoundException;
>>>>>>> c585e14 (Fix sign in and sign up)
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

<<<<<<< HEAD
    private final UserRepository userRepository;

=======
>>>>>>> c585e14 (Fix sign in and sign up)
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
<<<<<<< HEAD
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
=======
        return userRepository.findByEmail(username)
                .stream()
                .findFirst()
                .map(user -> User.builder()
                        .username(user.getEmail())
                        .password(user.getPassword())
                        .authorities("ROLE_USER")
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
>>>>>>> c585e14 (Fix sign in and sign up)
    }
}
