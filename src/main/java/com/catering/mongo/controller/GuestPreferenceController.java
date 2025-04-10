package com.catering.mongo.controller;

import com.catering.mongo.model.Event;
import com.catering.mongo.model.GuestPreference;
import com.catering.mongo.model.Item;
import com.catering.mongo.repository.EventRepository;
import com.catering.mongo.repository.GuestPreferenceRepository;
import com.catering.mongo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guest")
@CrossOrigin(origins = "*")
public class  GuestPreferenceController {

    @Autowired
    private GuestPreferenceRepository guestRepo;

    @Autowired
    private EventRepository eventRepo;

    // Guest submits preference after validation
    @PostMapping("/submit")
    public ResponseEntity<?> submitPreference(@RequestBody GuestPreference submission) {
        Optional<Event> event = eventRepo.findByEventIdAndEventPassword(
                submission.getEventId(), submission.getPassword()
        );

        if (event.isPresent()) {
            submission.setPassword(null); // avoid saving password
            return ResponseEntity.ok(guestRepo.save(submission));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Event ID or Password");
        }
    }

    @PostMapping("/login")
    public List<GuestPreference> getGuestEntries(@RequestBody GuestPreference submission) {
        return guestRepo.findByEventIdAndPassword(submission.getEventId(), submission.getPassword());
    }

    @GetMapping("/submissions/{eventId}")
    public List<GuestPreference> getAllSubmissions(@PathVariable String eventId) {
        return guestRepo.findByEventId(eventId);
    }
}
