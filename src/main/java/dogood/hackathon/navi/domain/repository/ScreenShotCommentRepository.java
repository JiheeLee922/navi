
package dogood.hackathon.navi.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dogood.hackathon.navi.domain.entity.ScreenShotCommentEntity;
import dogood.hackathon.navi.domain.entity.ScreenShotEntity;

public interface ScreenShotCommentRepository extends JpaRepository<ScreenShotCommentEntity, Long> {

	
	@Query(value="select ssc.* , ui.NICK_NM ,ui.PROFILE_IMG_PATH \r\n"
			+ "from screen_shot_comment ssc \r\n"
			+ "inner join user_info ui \r\n"
			+ "on ssc.USER_IDX = ui.USER_IDX \r\n"
			+ "where ssc.SCREEN_SHOT_IDX =:shotIdx"
			,nativeQuery=true)
	public List<ScreenShotCommentEntity> listShotCommentById(@Param("shotIdx") Long screenShotIdx);
}
