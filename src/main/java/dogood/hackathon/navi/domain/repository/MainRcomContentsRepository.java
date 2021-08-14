package dogood.hackathon.navi.domain.repository;

import dogood.hackathon.navi.domain.entity.MainRecommandContentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;

public interface MainRcomContentsRepository extends JpaRepository<MainRecommandContentsEntity, Long> {

    public MainRecommandContentsEntity findBy(Timestamp searhTime);
}
