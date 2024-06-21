package edu.supdevinci.eventmanagementapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ParticipationDto {
    private Long id;
    private Long userId;
    private Long eventId;
    private Boolean isConfirmed;
    private String message;
    private Date createdAt;
}
