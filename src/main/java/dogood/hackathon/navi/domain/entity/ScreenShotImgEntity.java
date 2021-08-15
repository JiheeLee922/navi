package dogood.hackathon.navi.domain.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="screen_shot_img")
public class ScreenShotImgEntity{
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idx;
	
    @Column(name="screen_shot_idx")
    private Long screenShotIdx;

    @Column
    private String img_path;
    
    @Column
    private String smi;

    @Builder
	public ScreenShotImgEntity(Long idx, Long screen_shot_idx, String img_path, String smi) {
		this.idx = idx;
		this.screenShotIdx = screen_shot_idx;
		this.img_path = img_path;
		this.smi = smi;
	}
    

    
    
 
}
