package ro.helator.gameprofiler.repository.player.campaign;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface PlayerCampaignRepository extends JpaRepository<PlayerCampaignEntity, Long> {
    @Modifying
    @Query("delete PlayerCampaignEntity pc where pc.playerId in (:playerIds)")
    void deleteByPlayerIdIn(@Param("playerIds") Collection<UUID> playerIds);

    @Modifying
    @Query("delete PlayerCampaignEntity pc")
    void deleteAll();
}
