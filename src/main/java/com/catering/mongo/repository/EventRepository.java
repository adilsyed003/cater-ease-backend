package com.catering.mongo.repository;

import com.catering.mongo.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EventRepository extends MongoRepository<Event, String> {
    Optional<Event> findByEventId(String eventId);
    Optional<Event> findByEventIdAndEventPassword(String eventId, String eventPassword);
    Optional<Event> findByEventIdAndEventPasswordAndName(String eventId, String eventPassword, String name);

}
