package ro.helator.gameprofiler.service.campaign;

import org.springframework.stereotype.Component;
import ro.helator.gameprofiler.repository.campaign.CampaignEntity;
import ro.helator.gameprofiler.repository.player.profile.PlayerProfileEntity;
import ro.helator.gameprofiler.service.campaign.matchers.AbstractMatcher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CampaignMatcher {

    private final Map<String,AbstractMatcher> matchersByKey = new HashMap<>();

    public CampaignMatcher(List<AbstractMatcher> matchers) {
        matchers.forEach(m -> this.matchersByKey.put(m.getType(),m));
    }


    public boolean match(CampaignEntity campaign, PlayerProfileEntity playerProfile) {
        Map<String, Object> matchers = campaign.getMatchers();
        if(matchers == null || matchers.isEmpty()) {
            return true;
        }
        int matchCount = 0;
        for(Map.Entry<String, Object> entry : matchers.entrySet()) {
            AbstractMatcher matcher = this.matchersByKey.get(entry.getKey());
            if (matcher == null || !matcher.match((Map<String, Object>) entry.getValue(), playerProfile)) {
                break;
            }
            matchCount++;
        }
        return matchCount == matchers.size();
    }
}
