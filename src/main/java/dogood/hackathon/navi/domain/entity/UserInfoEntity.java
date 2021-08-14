package dogood.hackathon.navi.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="user_info")
public class UserInfoEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_idx")
    private Long userIdx;

    @Column(name="nick_nm")
    private String nickNm;

    @Column(name="profile_img_path")
    private String prflImgPath;

    @Column(name="login_id")
    private String loginId;

    @Transient
    private String resultCd ="S";

    @Builder
    public UserInfoEntity(Long userIdx, String loginId, String nickNm,String prflImgPath) {
        this.userIdx = userIdx;
        this.loginId = loginId;
        this.nickNm = nickNm;
        this.prflImgPath = prflImgPath;
    }
}
