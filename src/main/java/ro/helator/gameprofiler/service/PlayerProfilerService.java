package ro.helator.gameprofiler.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlayerProfilerService {


    public Object getProfile(UUID playerId) {
        return playerId;
    }
}
