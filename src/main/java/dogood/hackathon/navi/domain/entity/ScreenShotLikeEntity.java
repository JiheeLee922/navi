package dogood.hackathon.navi.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="screen_shot_like")
public class ScreenShotLikeEntity extends TimeEntity{
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long like_idx;

	@ManyToOne
	@JoinColumn(name="screen_shot_idx")
    private ScreenShotEntity screen_shot_idx;

    @Column
    private String user_idx;

	/*
	 * @Builder public ScreenShotLikeEntity(Long like_idx, ScreenShotEntity
	 * screen_shot, String user_idx) { this.like_idx = like_idx; this.screen_shot =
	 * screen_shot; this.user_idx = user_idx; }
	 */

}
