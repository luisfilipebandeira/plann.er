package com.luisbandeira.planner.link;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, UUID> {
    
    List<Link> findAllByTripId(UUID tripId);
}
