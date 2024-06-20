package edu.supdevinci.eventmanagementapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EventManagementApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventManagementApiApplication.class, args);
    }

}
