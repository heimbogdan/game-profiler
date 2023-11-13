package ro.helator.gameprofiler.service.campaign.matchers;

import org.springframework.stereotype.Component;
import ro.helator.gameprofiler.repository.player.profile.PlayerProfileEntity;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class DoesNotHaveMatcher extends AbstractMatcher {
    @Override
    public String getType() {
        return "does_not_have";
    }

    @Override
    public boolean match(Map<String, Object> rules, PlayerProfileEntity playerProfile) {
        List<String> items = (List<String>) rules.getOrDefault("items", Collections.EMPTY_LIST);
        Set<String> inventorySet = playerProfile.getInventory().keySet();
        return items.isEmpty() || !items.stream().anyMatch(inventorySet::contains);
    }
}
