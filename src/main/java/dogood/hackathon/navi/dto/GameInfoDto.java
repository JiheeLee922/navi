package dogood.hackathon.navi.dto;

import dogood.hackathon.navi.domain.entity.GameInfoEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GameInfoDto {

    private Long gameIdx;
    private String gameNm;
    private String gameDivision;
    private String thumbNail;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    public GameInfoEntity toEntity(){
        GameInfoEntity gameInfoEntity = GameInfoEntity.builder()
                .gameIdx(gameIdx)
                .gameNm(gameNm)
                .gameDivision(gameDivision)
                .thumbNail(thumbNail)
                .build();
        return gameInfoEntity;
    }

    @Builder
    public GameInfoDto(Long gameIdx, String gameNm, String gameDivision, String thumbNail, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.gameIdx = gameIdx;
        this.gameNm = gameNm;
        this.gameDivision = gameDivision;
        this.thumbNail = thumbNail;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
