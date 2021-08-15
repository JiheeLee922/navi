
package dogood.hackathon.navi.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dogood.hackathon.navi.domain.entity.ScreenShotImgEntity;

public interface ScreenShotImgRepository extends JpaRepository<ScreenShotImgEntity, Long> {

	public List<ScreenShotImgEntity> getScreenShotImgEntityByScreenShotIdx(Long screen_shot_idx);
}
