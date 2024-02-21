package com.asius.bookshop.Entity;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "events")
@Data
public class EventsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvent;
    private String title;
    private String img;
    private String type;
    private String description;
    private String specialGuest;
    private String location;
    private String dateOfEvent;

    public EventsEntity(){}
}
