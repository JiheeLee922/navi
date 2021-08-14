package dogood.hackathon.navi.domain.repository;

import dogood.hackathon.navi.domain.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {
    public int countByLoginId(String loginId);
    public int countByNickNm(String nickNm);

    public UserInfoEntity getUserInfoEntityByLoginId(String loginId);

}
