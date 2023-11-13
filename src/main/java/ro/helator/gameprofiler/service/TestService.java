package ro.helator.gameprofiler.service;

import org.springframework.stereotype.Service;
import ro.helator.gameprofiler.repository.player.campaign.PlayerCampaignRepository;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class TestService {

    private final PlayerCampaignRepository playerCampaignRepository;

    public TestService(PlayerCampaignRepository playerCampaignRepository) {
        this.playerCampaignRepository = playerCampaignRepository;
    }

    @Transactional
    public void resetCampaigns(Set<UUID> ids) {
        if (null != ids && !ids.isEmpty()) {
            playerCampaignRepository.deleteByPlayerIdIn(ids);
        } else {
            this.playerCampaignRepository.deleteAll();
        }
    }
}
