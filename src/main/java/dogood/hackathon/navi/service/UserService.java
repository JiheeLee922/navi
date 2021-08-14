package dogood.hackathon.navi.service;

import com.sun.istack.Nullable;
import dogood.hackathon.navi.domain.entity.UserInfoEntity;
import dogood.hackathon.navi.domain.repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserService {
    private UserInfoRepository repository;

    @Transactional
    @Transient
    public UserInfoEntity join(String loginId, String nickNm , @Nullable String prflImgPath) throws Exception{
        if(repository.countByLoginId(loginId) > 0){
            throw new Exception("아이디를 다시 입력해주세요.");
        }
        if(repository.countByNickNm(nickNm) > 0){
            throw new Exception("닉네임을 다시 입력해주세요.");
        }
        UserInfoEntity po = new UserInfoEntity(null,loginId,nickNm,prflImgPath);
        repository.save(po);
        return login(po.getLoginId());
    }

    @Transactional
    public UserInfoEntity login(String loginId) throws Exception{
        if(repository.countByLoginId(loginId) == 0){
            throw new Exception("아이디를 확인해주세요.");
        }
        return repository.getUserInfoEntityByLoginId(loginId);
    }
}
