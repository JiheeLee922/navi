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
@Table(name="SCREEN_SHOT")
public class ScreenShotEntity{
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long screen_shot_idx;
	
    @Column
    private Long game_idx;

    @Column
    private Long user_idx;

    @Column
    private Date journey_strt_dtm;

    @Column
    private String thumbnail_path;
    
    @Column
    private String position;
    
    @Column
    private Timestamp regist_dtm;
    
    private String game_nm;
    
	/*
	 * @OneToMany(mappedBy="screen_shot_idx") private List<ScreenShotLikeEntity>
	 * likes;
	 */
    
    

    @Builder
    public ScreenShotEntity(Long screen_shot_idx,Long game_idx, Long user_idx,String content, Date journey_strt_dtm,  String thumbnail_path, String position) {
        this.screen_shot_idx = screen_shot_idx;
        this.game_idx = game_idx;
        this.user_idx = user_idx;
        this.journey_strt_dtm = journey_strt_dtm;
        this.thumbnail_path = thumbnail_path;
        this.position = position;
        //this.likes = likes;
    }
}
