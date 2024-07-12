package com.luisbandeira.planner.activity;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisbandeira.planner.trip.Trip;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository repository;
    
    public ActivityReponse registerActivity(ActivityRequestPayload payload, Trip trip) {
        Activity newActivity = new Activity(payload.title(), payload.occurs_at(), trip);

        this.repository.save(newActivity);

        return new ActivityReponse(newActivity.getId());
    }

    public List<ActivityData> getActivityFromId(UUID tripId) {
        return this.repository.findAllByTripId(tripId).stream().map(activities -> new ActivityData(activities.getId(), activities.getTitle(), activities.getOccursAt())).toList();
    }
}
