package ro.helator.gameprofiler.repository.campaign;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "CAMPAIGNS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CampaignEntity {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue
    @Column(name = "ID")
    private UUID id;

    @Column(name = "GAME")
    private String game;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRIORITY")
    private BigDecimal priority;

    @Type(type = "json")
    @Column(name = "MATCHERS")
    private Map<String, Object> matchers;

    @Column(name = "START_DATE")
    private OffsetDateTime startDate;

    @Column(name = "END_DATE")
    private OffsetDateTime endDate;

    @Column(name = "ENABLED")
    private Boolean enabled;

    @Column(name = "LAST_UPDATED")
    private OffsetDateTime lastUpdated;
}
