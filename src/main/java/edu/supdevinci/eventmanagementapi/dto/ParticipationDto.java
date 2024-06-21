package edu.supdevinci.eventmanagementapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ParticipationDto {
    private Long id;
    private Long userId;
    private Long eventId;
    private Boolean isConfirmed;
    private String message;
    private Date createdAt;
}
