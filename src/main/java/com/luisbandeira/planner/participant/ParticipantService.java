package com.luisbandeira.planner.participant;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ParticipantService {
    
    public void registerParticipantToEvent(List<String> participantToInvite, UUID tripId) {}

    public void triggerConfirmationEmailToParticipants(UUID tripId) {}
}
