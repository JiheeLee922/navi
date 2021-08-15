package dogood.hackathon.navi.domain.repository;

import dogood.hackathon.navi.domain.entity.GameInfoEntity;
import dogood.hackathon.navi.domain.entity.MainRecommandContentsEntity;
import dogood.hackathon.navi.domain.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface MainRepository extends JpaRepository<MainRecommandContentsEntity, Long> {
    @Query(
            value = "SELECT RECOMMAND_IDX, SHOW_STRT_DTM, SHOW_END_DTM, SHOW_TITLE, SHOW_DESCRIPTION , gi.THUMBNAIL_PATH " +
            "FROM main_recommand_contents mrc " +
            "INNER JOIN game_info gi on mrc.GAME_IDX = gi.GAME_IDX " +
            "WHERE :currentTime BETWEEN SHOW_STRT_DTM AND SHOW_END_DTM" , nativeQuery = true
    )
    public MainRecommandContentsEntity getMainContents(@Param("currentTime")Timestamp currentTime);

    @Query(
            value = "SELECT t.tag_nm " +
            "from tag t " +
            "inner join main_recommand_tag_mapping mrtm on t.TAG_IDX = mrtm.TAG_IDX " +
            "where mrtm.RECOMMAND_IDX = :rcomIdx " , nativeQuery = true
    )
    public List<String> getMainTag(@Param("rcomIdx")Long rcomIdx);

}
