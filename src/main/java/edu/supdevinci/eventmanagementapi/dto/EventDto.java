package edu.supdevinci.eventmanagementapi.dto;

import edu.supdevinci.eventmanagementapi.model.database.Interest;
import edu.supdevinci.eventmanagementapi.model.database.Participation;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class EventDto {
    private String name;
    private String location;
    private Float price;
    private String type;
    private Date startDate;
    private Integer totalPlaces;
    private List<Interest> interests;
    private List<Participation> participations;
}
