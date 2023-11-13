package ro.helator.gameprofiler.service.campaign.matchers;

import ro.helator.gameprofiler.repository.player.profile.PlayerProfileEntity;

import java.util.Map;

public abstract class AbstractMatcher {

    public abstract String getType();

    public abstract boolean match(Map<String, Object> rules, PlayerProfileEntity playerProfile);
}
