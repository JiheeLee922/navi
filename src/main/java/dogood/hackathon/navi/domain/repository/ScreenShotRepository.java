
package dogood.hackathon.navi.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import dogood.hackathon.navi.domain.entity.ScreenShotEntity;

public interface ScreenShotRepository extends JpaRepository<ScreenShotEntity, Long> {

	@Query(value="select ss.*, gi.GAME_NM, \r\n"
			+ "(select count(*) from screen_shot_like ssl2 where ss.SCREEN_SHOT_IDX = screen_shot_idx ) likeCnt\r\n"
			+ "from screen_shot ss \r\n"
			+ "inner join game_info gi \r\n"
			+ "on ss.GAME_IDX = gi.GAME_IDX \r\n"
			+ "order by likeCnt desc"
			, nativeQuery=true)
	public List<ScreenShotEntity> rnbList();
}
