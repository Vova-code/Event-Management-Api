package edu.supdevinci.eventmanagementapi.model.database;

import edu.supdevinci.eventmanagementapi.dto.EventDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.Date;
import java.sql.Time;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with", toBuilder = true)
@Table(name = "event")
@BatchSize(size = 10)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "total_places", nullable = false)
    private int totalPlaces;

    @Column(name = "price", nullable = false)
    private float price;

    @OneToMany(mappedBy = "event")
    private List<Participation> participations;

    @ManyToMany
    @JoinTable(
            name = "event_interest",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id")
    )
    private List<Interest> interests;
}
