package dogood.hackathon.navi.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ScreenShotCommentDto {

	private Integer screenShotCommentIdx;
    private Integer screenShotIdx;
	private Integer userIdx;
	private String commentContent;
	private Timestamp registDtm;
	private String nickNm;
	private String profileImgPath;
	
	@Builder
	public ScreenShotCommentDto(Integer screenShotCommentIdx, Integer screenShotIdx, Integer userIdx, String commentContent,
			Timestamp registDtm, String nickNm, String profileImgPath) {
		this.screenShotCommentIdx = screenShotCommentIdx;
		this.screenShotIdx = screenShotIdx;
		this.userIdx = userIdx;
		this.commentContent = commentContent;
		this.registDtm = registDtm;
		this.nickNm = nickNm;
		this.profileImgPath = profileImgPath;
	}
	
    
	
    


}
