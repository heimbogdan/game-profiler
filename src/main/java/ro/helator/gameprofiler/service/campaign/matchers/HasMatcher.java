package ro.helator.gameprofiler.service.campaign.matchers;

import org.springframework.stereotype.Component;
import ro.helator.gameprofiler.repository.player.profile.PlayerProfileEntity;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class HasMatcher extends AbstractMatcher{

    @Override
    public String getType() {
        return "has";
    }

    @Override
    public boolean match(Map<String, Object> rules, PlayerProfileEntity playerProfile) {
        List<String> countries = (List<String>) rules.getOrDefault("country", Collections.EMPTY_LIST);
        List<String> items = (List<String>) rules.getOrDefault("items", Collections.EMPTY_LIST);
        return (countries.isEmpty() || countries.contains(playerProfile.getCounty().toString()))
                && (items.isEmpty() || playerProfile.getInventory().keySet().containsAll(items));
    }
}
