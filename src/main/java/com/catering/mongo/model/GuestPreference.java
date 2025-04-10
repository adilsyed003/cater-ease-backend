package com.catering.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "guest_preferences")
public class GuestPreference {

    @Id
    private String id;
    private String eventId;
    private String guestName;
    private String password;
    private String preference;
    private List<String> suggestedDishes;
    private String personalMessage;

    public String getPersonalMessage() {
        return personalMessage;
    }

    public void setPersonalMessage(String personalMessage) {
        this.personalMessage = personalMessage;
    }

    public List<String> getSuggestedDishes() {
        return suggestedDishes;
    }

    public void setSuggestedDishes(List<String> suggestedDishes) {
        this.suggestedDishes = suggestedDishes;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }




    // Getters and setters
}
