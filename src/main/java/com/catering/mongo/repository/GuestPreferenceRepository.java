package com.catering.mongo.repository;

import com.catering.mongo.model.GuestPreference;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GuestPreferenceRepository extends MongoRepository<GuestPreference, String> {
    List<GuestPreference> findByEventIdAndPassword(String eventId, String password);
    List<GuestPreference> findByEventId(String eventId);
}

