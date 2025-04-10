package com.catering.mongo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "events")
public class Event {
    @Id
    private String id;
    private String name;
    private String eventId;          // unique identifier for guests
    private String eventPassword;    // used by guests to "login"

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEventId() { return eventId; }
    public void setEventId(String eventId) { this.eventId = eventId; }

    public String getEventPassword() { return this.eventPassword; }
    public void setEventPassword(String eventPassword) { this.eventPassword = eventPassword; }
}
