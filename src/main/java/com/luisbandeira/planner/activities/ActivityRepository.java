package com.luisbandeira.planner.activities;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, UUID>{

    List<Activity> findAllByTripId(UUID tripId);
    
}
