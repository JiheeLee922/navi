package dogood.hackathon.navi.dto;

import java.sql.Date;
import java.sql.Timestamp;

import dogood.hackathon.navi.domain.entity.ScreenShotEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ScreenShotDto {

    private Long screenShotIdx;
	private Long gameIdx;
	private Long userIdx;
	private Date journeyStrtDtm;
	private String thumbnailPath;
	private String position;
	private Timestamp registDtm;
	private String gameNm;
	private String title;
	private String description;
    private String corpNm;
    private String tag;
	
    
    public ScreenShotEntity toEntity() {
    	ScreenShotEntity screenShotEntity = ScreenShotEntity.builder()
    			.screen_shot_idx(screenShotIdx)
    			.game_idx(gameIdx)
    			.user_idx(userIdx)
    			.journey_strt_dtm(journeyStrtDtm)
    			.thumbnail_path(thumbnailPath)
    			.position(position)
    			.build();
    	
    	return screenShotEntity;
    }
    
    @Builder
    public ScreenShotDto(Long screenShotIdx, Long gameIdx, Long userIdx, Date journeyStrtDtm, String thumbnailPath,
			String position, Timestamp registDtm, String gameNm, String title, String description,
			String corp_nm, String tag) {
		this.screenShotIdx = screenShotIdx;
		this.gameIdx = gameIdx;
		this.userIdx = userIdx;
		this.journeyStrtDtm = journeyStrtDtm;
		this.thumbnailPath = thumbnailPath;
		this.position = position;
		this.registDtm = registDtm;
		this.gameNm = gameNm;
		this.title = title;
		this.description = description;
		this.corpNm = corp_nm;
		this.tag = tag;
	}


}
