package dogood.hackathon.navi.dto;

import dogood.hackathon.navi.domain.entity.ScreenShotImgEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ScreenShotImgDto {

    private Long screenShotIdx;
    private Long idx;
    private String imgPath;
    private String smi;
	
    
    public ScreenShotImgEntity toEntity() {
    	ScreenShotImgEntity imgEntity = ScreenShotImgEntity.builder()
    			.screen_shot_idx(screenShotIdx)
    			.idx(idx)
    			.img_path(imgPath)
    			.smi(smi)
    			.build();
    	
    	return imgEntity ;
    }

    @Builder
	public ScreenShotImgDto(Long screenShotIdx, Long idx, String img_path, String smi) {
		this.screenShotIdx = screenShotIdx;
		this.idx = idx;
		this.imgPath = img_path;
		this.smi = smi;
	}
    
    
    


}
