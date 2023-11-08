package ro.helator.gameprofiler.repository.player.campaign;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "PLAYER_CAMPAIGNS")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerCampaignEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Type(type = "uuid-char")
    @Column(name = "PLAYER_ID")
    private UUID playerId;

    @Type(type = "uuid-char")
    @Column(name = "CAMPAIGN_ID")
    private UUID campaignId;
}
