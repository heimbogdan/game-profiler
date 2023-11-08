package ro.helator.gameprofiler.repository.player.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerProfileRepository extends JpaRepository<PlayerProfileEntity, UUID> {
}
