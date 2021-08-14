package dogood.hackathon.navi.dto;

import dogood.hackathon.navi.domain.entity.UserInfoEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserInfoDto {
    private Long userIdx;
    private String loginId;
    private String nickNm;
    private String prflImgPath;

    public UserInfoEntity toEntitiy(){
        UserInfoEntity entity = UserInfoEntity.builder()
                .userIdx(userIdx)
                .loginId(loginId)
                .nickNm(nickNm)
                .prflImgPath(prflImgPath)
                .build();
        return entity;
    }

    @Builder
    public UserInfoDto(Long userIdx, String loginId, String nickNm,String prflImgPath) {
        this.userIdx = userIdx;
        this.loginId = loginId;
        this.nickNm = nickNm;
        this.prflImgPath = prflImgPath;
    }
}
