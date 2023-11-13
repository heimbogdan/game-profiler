package ro.helator.gameprofiler.controller.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;
import ro.helator.gameprofiler.repository.campaign.CampaignEntity;
import ro.helator.gameprofiler.repository.player.profile.PlayerProfileEntity;
import ro.helator.gameprofiler.service.model.*;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerProfileDto implements Serializable {
    private String credential;
    private OffsetDateTime created;
    private OffsetDateTime modified;
    private OffsetDateTime lastSession;
    private Integer totalSpent;
    private Integer totalRefund;
    private Integer totalTransactions;
    private OffsetDateTime lastPurchase;
    private Set<String> activeCampaigns;
    private List<Device> devices;
    private Integer level;
    private Long xp;
    private Integer totalPlaytime;
    private CountyCodeEnum county;
    private String language;
    private OffsetDateTime birthdate;
    private String gender;
    private Map<String, Integer> inventory;
    private ClanDto clan;
    private Map<String, Object> customFields;

    @JsonAnyGetter
    public Map<String, Object> getCustomFields() {
        return customFields;
    }

    public static PlayerProfileDto fromEntity(PlayerProfileEntity entity) {
        PlayerProfileDtoBuilder builder = PlayerProfileDto.builder();
        if(entity != null) {
            builder.credential(entity.getCredential() != null ? entity.getCredential().getType() : null)
                    .created(entity.getCreated() != null ? entity.getCreated().withOffsetSameLocal(ZoneOffset.UTC) : null)
                    .modified(entity.getCreated() != null ? entity.getCreated().withOffsetSameLocal(ZoneOffset.UTC) : null)
                    .lastSession(entity.getLastSession() != null ? entity.getLastSession().withOffsetSameLocal(ZoneOffset.UTC) : null)
                    .totalSpent(entity.getTotalSpent())
                    .totalRefund(entity.getTotalRefund())
                    .totalTransactions(entity.getTotalTransactions())
                    .lastPurchase(entity.getLastPurchase() != null ? entity.getLastPurchase().withOffsetSameLocal(ZoneOffset.UTC) : null)
                    .activeCampaigns(entity.getActiveCampaigns() != null ? entity.getActiveCampaigns().stream().map(CampaignEntity::getName).collect(Collectors.toSet()) : null)
                    .devices(entity.getDevices())
                    .level(entity.getLevel())
                    .xp(entity.getXp())
                    .totalPlaytime(entity.getTotalPlaytime())
                    .county(entity.getCounty())
                    .language(entity.getLanguage() != null ? entity.getLanguage().getCode() : null)
                    .birthdate(entity.getBirthdate() != null ? entity.getBirthdate().withOffsetSameLocal(ZoneOffset.UTC) : null)
                    .gender(entity.getGender() != null ? entity.getGender().getValue() : null)
                    .inventory(entity.getInventory())
                    .clan(ClanDto.fromEntity(entity.getClan()))
                    .customFields(entity.getCustomFields());

        }
        return builder.build();
    }
}