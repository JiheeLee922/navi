
package dogood.hackathon.navi.domain.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dogood.hackathon.navi.domain.entity.ScreenShotEntity;

public interface ScreenShotRepository extends JpaRepository<ScreenShotEntity, Long> {

	@Query(value="select ss.*, gi.GAME_NM, '' as corp_nm, '' as tag, \r\n"
			+ "(select count(*) from screen_shot_like ssl2 where ss.SCREEN_SHOT_IDX = screen_shot_idx ) likeCnt\r\n"
			+ "from screen_shot ss \r\n"
			+ "inner join game_info gi \r\n"
			+ "on ss.GAME_IDX = gi.GAME_IDX \r\n"
			+ "order by likeCnt desc"
			, nativeQuery=true)
	public List<ScreenShotEntity> rnbList();
	
	@Query(value="select ss.*, ui.NICK_NM , ui.PROFILE_IMG_PATH , ui.USER_IDX \r\n"
			+ ", (select GROUP_CONCAT(TAG_NM) from tag where TAG_IDX in (select TAG_IDX from screen_shot_tag_mapping sstm where sstm.SCREEN_SHOT_IDX =ss.SCREEN_SHOT_IDX )) tag\r\n"
			+ ",gi.GAME_NM , gi.CORP_NM \r\n"
			+ "from screen_shot ss \r\n"
			+ "inner join user_info ui \r\n"
			+ "on ss.USER_IDX = ui.USER_IDX \r\n"
			+ "inner join game_info gi \r\n"
			+ "on ss.GAME_IDX = gi.GAME_IDX \r\n"
			+ "where ss.SCREEN_SHOT_IDX = :screenShotIdx "
			,nativeQuery=true)
	public ScreenShotEntity getScreenShotInfo(@Param("screenShotIdx") Long screenShotIdx);
	
	
	@Query(value="select  SCREEN_SHOT_IDX  ,a.THUMBNAIL_PATH as Thumb_shot ,gi.GAME_NM ,gi.THUMBNAIL_PATH  \r\n"
			+ "from (\r\n"
			+ "	SELECT  count(*) cnt,  ss.SCREEN_SHOT_IDX ,GAME_IDX ,THUMBNAIL_PATH \r\n"
			+ "	from screen_shot ss \r\n"
			+ "	inner join screen_shot_tag_mapping sstm \r\n"
			+ "	on ss.SCREEN_SHOT_IDX = sstm.SCREEN_SHOT_IDX \r\n"
			+ "	inner join tag t \r\n"
			+ "	on sstm.TAG_IDX = t.TAG_IDX \r\n"
			+ "	where t.TAG_NM in (:tag)\r\n"
			+ "	group by SCREEN_SHOT_IDX\r\n"
			+ "	order by count(*) desc\r\n"
			+ "	limit 3\r\n"
			+ "	) a\r\n"
			+ "inner join game_info gi \r\n"
			+ "on a.GAME_IDX = gi.GAME_IDX \r\n"
			+ "where a.screen_shot_idx !=:screenShotIdx \r\n"
			+ "order by cnt desc"
			, nativeQuery=true)
	public Object[] listRecommendGame( @Param("tag") Set<String> set, @Param("screenShotIdx") Long screenShotIdx);
	
	
	
	@Query(value="select ss.screen_shot_idx , ss.thumbnail_path , gi.game_nm ,\r\n"
			+ "gi.THUMBNAIL_PATH as game_thumb \r\n"
			+ "from screen_shot ss \r\n"
			+ "inner join game_info gi \r\n"
			+ "on ss.GAME_IDX  = gi.GAME_IDX \r\n"
			+ "where 1=1\r\n"
			+ " and(:#{#search != 'all'} = true or (    ss.SCREEN_SHOT_IDX  = (select screen_shot_idx from screen_shot_tag_mapping sstm  \r\n"
			+ "																where sstm.TAG_IDX = (select tag_idx from tag where tag_nm = :searchWord ))\r\n"
			+ "											or gi.GAME_NM like concat('%',:searchWord,'%')   \r\n"
			+ "											or ss.POSITION like concat('%',:searchWord,'%')  \r\n"
			+ "		))  \r\n"
			+ " and(:#{#search != 'tag'} = true or (ss.SCREEN_SHOT_IDX  = (select screen_shot_idx from screen_shot_tag_mapping sstm\r\n"
			+ "									where sstm.TAG_IDX = (select tag_idx from tag where tag_nm = :searchWord )))) \r\n"
			+ " and(:#{#search != 'game'} = true or (gi.GAME_NM  like concat('%',:searchWord,'%') )) \r\n"
			+ " and(:#{#search != 'position'} = true or (ss.POSITION  like concat('%',:searchWord,'%') )) \r\n"
			+ "order by (select count(*) from screen_shot_like ssl2 where ssl2.screen_shot_idx = ss.screen_shot_idx )  desc "
			,nativeQuery=true)
	public Object[] listScreenShotSearch( @Param("search") String search, @Param("searchWord") String searchWord);
}
