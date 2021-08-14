package dogood.hackathon.navi.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="game_info")
public class GameInfoEntity extends TimeEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long gameIdx;

    @Column(length = 10, nullable = false)
    private String gameNm;

    @Column(length = 100, nullable = false)
    private String gameDivision;

    @Column(columnDefinition = "THUMBNAIL_PATH", nullable = false)
    private String thumbNail;

    @Builder
    public GameInfoEntity(Long gameIdx, String gameNm, String gameDivision, String thumbNail) {
        this.gameIdx = gameIdx;
        this.gameNm = gameNm;
        this.gameDivision = gameDivision;
        this.thumbNail = thumbNail;
    }
}
