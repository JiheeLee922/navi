package dogood.hackathon.navi.domain.repository;

import dogood.hackathon.navi.domain.entity.GameInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameInfoRepository extends JpaRepository<GameInfoEntity, Long> {
    @Query(
            value = "SELECT gi.GAME_IDX, gi.GAME_NM , gi.GAME_DIVISION , gi.THUMBNAIL_PATH , gi.CORP_NM " +
                    "FROM game_info gi " +
                    "WHERE gi.game_idx in ( " +
                    "        SELECT gtm.GAME_IDX " +
                    "        FROM game_tag_mapping gtm " +
                    "        inner join main_recommand_tag_mapping mrtm on mrtm.tag_idx = gtm.TAG_IDX " +
                    "        WHERE mrtm.RECOMMAND_IDX = :rcomIdx " +
                    ")" , nativeQuery = true

    )
    public List<GameInfoEntity> getMainGameList(@Param("rcomIdx")Long rcomIdx);
}
