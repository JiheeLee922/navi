package dogood.hackathon.navi.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="game_info")
public class GameInfoEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="GAME_IDX")
    private Long gameIdx;

    @Column(name="GAME_NM")
    private String gameNm;

    @Column(name="GAME_DIVISION")
    private String gameDivision;

    @Column(name = "THUMBNAIL_PATH")
    private String thumbNail;

    @Column(name="CORP_NM")
    private String corpNm;

    @Builder
    public GameInfoEntity(Long gameIdx, String gameNm, String gameDivision, String thumbNail,String corpNm) {
        this.gameIdx = gameIdx;
        this.gameNm = gameNm;
        this.gameDivision = gameDivision;
        this.thumbNail = thumbNail;
        this.corpNm = corpNm;
    }
}
