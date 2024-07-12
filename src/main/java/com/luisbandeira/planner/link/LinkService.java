package com.luisbandeira.planner.link;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisbandeira.planner.activity.Activity;
import com.luisbandeira.planner.activity.ActivityData;
import com.luisbandeira.planner.activity.ActivityReponse;
import com.luisbandeira.planner.activity.ActivityRequestPayload;
import com.luisbandeira.planner.trip.Trip;

@Service
public class LinkService {

    @Autowired
    private LinkRepository repository;
    

    public LinkResponse registerLink(LinkRequestPayload payload, Trip trip) {
        Link newLink = new Link(payload.title(), payload.url(), trip);

        this.repository.save(newLink);

        return new LinkResponse(newLink.getId());
    }

    public List<LinkData> getLinkFromId(UUID tripId) {
        return this.repository.findAllByTripId(tripId).stream().map(link -> new LinkData(link.getId(), link.getTitle(), link.getUrl())).toList();
    }
}
