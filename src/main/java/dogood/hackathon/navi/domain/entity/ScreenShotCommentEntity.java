package dogood.hackathon.navi.domain.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="screen_shot_comment")
public class ScreenShotCommentEntity{
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer screen_shot_comment_idx; 
	
    @Column
    private Integer screen_shot_idx;

    @Column
    private Integer user_idx;

    @Column
    private String comment_content;
    
    @Column
    private Timestamp regist_dtm;
    
    private String nick_nm;
    
    private String profile_img_path;
    
    
    @Builder
    public ScreenShotCommentEntity(Integer screen_shot_comment_idx, Integer screen_shot_idx, Integer user_idx,
			String comment_content, Timestamp regist_dtm, String nick_nm, String profile_img_path) {
		this.screen_shot_comment_idx = screen_shot_comment_idx;
		this.screen_shot_idx = screen_shot_idx;
		this.user_idx = user_idx;
		this.comment_content = comment_content;
		this.regist_dtm = regist_dtm;
		this.nick_nm = nick_nm;
		this.profile_img_path = profile_img_path;
	}



}
