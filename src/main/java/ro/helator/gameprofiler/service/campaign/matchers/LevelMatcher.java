package ro.helator.gameprofiler.service.campaign.matchers;

import org.springframework.stereotype.Component;
import ro.helator.gameprofiler.repository.player.profile.PlayerProfileEntity;

import java.util.Map;

@Component
public class LevelMatcher extends AbstractMatcher {

    public static final int SKIP_VALUE = -1;

    @Override
    public String getType() {
        return "level";
    }

    @Override
    public boolean match(Map<String, Object> rules, PlayerProfileEntity playerProfile) {
        Integer min = (Integer) rules.getOrDefault("min", SKIP_VALUE);
        Integer max = (Integer) rules.getOrDefault("max", SKIP_VALUE);
        return (min == SKIP_VALUE || playerProfile.getLevel() >= min)
                && (max == SKIP_VALUE || playerProfile.getLevel() <= max);
    }
}
