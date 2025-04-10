package com.catering.mongo.controller;

import com.catering.mongo.model.Event;
import com.catering.mongo.model.GuestPreference;
import com.catering.mongo.repository.EventRepository;
import com.catering.mongo.repository.GuestPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/organizer")
@CrossOrigin(origins = "*")
public class EventController {

    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private GuestPreferenceRepository guestRepo;

    // Create an event (organizer only)
    @PostMapping("/create")
    public Event createEvent(@RequestBody Event event) {
        return eventRepo.save(event);
    }

    // Validate event for guest login
    @PostMapping("/validate")
    public Optional<Event> validateEvent(@RequestBody Event event) {
        return eventRepo.findByEventIdAndEventPassword(event.getEventId(), event.getEventPassword());
    }

    // Fetch event details (optional)
    @GetMapping("/{eventId}")
    public Optional<Event> getEvent(@PathVariable String eventId) {
        return eventRepo.findByEventId(eventId);
    }

    @PostMapping("/submissions")
    public ResponseEntity<?> getSubmissions(@RequestBody Event request) {
        Optional<Event> event = eventRepo.findByEventIdAndEventPasswordAndName(
                request.getEventId(), request.getEventPassword(), request.getName()
        );

        if (event.isPresent()) {

            List<GuestPreference> guests = guestRepo.findByEventId(request.getEventId());
            return ResponseEntity.ok(guests);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
