package ro.helator.gameprofiler.repository.campaign;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<CampaignEntity, String> {
    @Query("select c from CampaignEntity c where c.startDate < now() and c.endDate > now() and c.enabled = true")
    List<CampaignEntity> findAllActive();
}
