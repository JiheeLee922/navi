package dogood.hackathon.navi.domain.repository;

import dogood.hackathon.navi.domain.entity.GameInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameInfoRepository extends JpaRepository<GameInfoEntity, Long> {
}
