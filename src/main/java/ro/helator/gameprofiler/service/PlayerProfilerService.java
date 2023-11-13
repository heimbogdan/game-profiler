package ro.helator.gameprofiler.service;

import org.springframework.stereotype.Service;
import ro.helator.gameprofiler.controller.dto.PlayerProfileDto;
import ro.helator.gameprofiler.repository.campaign.CampaignEntity;
import ro.helator.gameprofiler.repository.campaign.CampaignRepository;
import ro.helator.gameprofiler.repository.player.profile.PlayerProfileEntity;
import ro.helator.gameprofiler.repository.player.profile.PlayerProfileRepository;
import ro.helator.gameprofiler.service.campaign.CampaignMatcher;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PlayerProfilerService {

    private final PlayerProfileRepository playerProfileRepository;
    private final CampaignRepository campaignRepository;
    private final CampaignMatcher campaignMatcher;

    public PlayerProfilerService(PlayerProfileRepository playerProfileRepository, CampaignRepository campaignRepository, CampaignMatcher campaignMatcher) {
        this.playerProfileRepository = playerProfileRepository;
        this.campaignRepository = campaignRepository;
        this.campaignMatcher = campaignMatcher;
    }

    @Transactional
    public PlayerProfileDto getProfile(UUID playerId) {
        Optional<PlayerProfileEntity> result = this.playerProfileRepository.findById(playerId);
        if (result.isEmpty()) {
            return null;
        }

        PlayerProfileEntity playerProfileEntity = result.get();
        List<CampaignEntity> allActive = campaignRepository.findAllActive();
        Set<CampaignEntity> matchedCampaings = allActive.stream().filter(c -> this.campaignMatcher.match(c, playerProfileEntity)).collect(Collectors.toSet());
        playerProfileEntity.getActiveCampaigns().addAll(matchedCampaings);
        this.playerProfileRepository.save(playerProfileEntity);
        return PlayerProfileDto.fromEntity(playerProfileEntity);
    }
}
