package ro.helator.gameprofiler.repository.player.profile;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ro.helator.gameprofiler.repository.campaign.CampaignEntity;
import ro.helator.gameprofiler.service.model.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "PLAYER_PROFILE")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TypeDef(name = "json", typeClass = JsonType.class)
public class PlayerProfileEntity {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue
    @Column(name = "ID")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "CREDENTIAL")
    private CredentialEnum credential;

    @Column(name = "CREATED")
    private OffsetDateTime created;

    @Column(name = "MODIFIED")
    private OffsetDateTime modified;

    @Column(name = "LAST_SESSION")
    private OffsetDateTime lastSession;

    @Column(name = "TOTAL_SPENT")
    private int totalSpent;

    @Column(name = "TOTAL_REFUND")
    private int totalRefund;

    @Column(name = "TOTAL_TRANSACTIONS")
    private int totalTransactions;

    @Column(name = "LAST_PURCHASE")
    private OffsetDateTime lastPurchase;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "PLAYER_CAMPAIGNS",
            joinColumns = @JoinColumn(name = "PLAYER_ID"),
            inverseJoinColumns = @JoinColumn(name = "CAMPAIGN_ID")
    )
    private Set<CampaignEntity> activeCampaigns;

    @Type(type = "json")
    @Column(name = "DEVICES")
    private List<Device> devices;

    @Column(name = "LEVEL")
    private Integer level;

    @Column(name = "XP")
    private Long xp;

    @Column(name = "TOTAL_PLAYTIME")
    private Integer totalPlaytime;

    @Enumerated(EnumType.STRING)
    @Column(name = "COUNTRY")
    private CountyCodeEnum county;

    @Column(name = "LANGUAGE")
    private LanguageEnum language;

    @Column(name = "BIRTHDATE")
    private OffsetDateTime birthdate;

    @Column(name = "GENDER")
    private GenderEnum gender;

    @Type(type = "json")
    @Column(name = "INVENTORY")
    private Map<String, Integer> inventory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLAN")
    private CampaignEntity clan;

    @Type(type = "json")
    @Column(name = "CUSTOM_FIELDS")
    private Map<String, Object> customFields;
}
