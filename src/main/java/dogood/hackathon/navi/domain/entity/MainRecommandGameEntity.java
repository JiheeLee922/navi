package dogood.hackathon.navi.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="main_recommand_game" )
public class MainRecommandGameEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="main_recommand_idx")
    private Long mainRcomIdx;

    @Column(name="recommand_idx")
    private Long rcomIdx;

    @Column(name="game_idx")
    private Long gameIdx;

    @Builder
    public MainRecommandGameEntity(Long mainRcomIdx,Long rcomIdx,Long gameIdx){
        this.mainRcomIdx = mainRcomIdx;
        this.rcomIdx = rcomIdx;
        this.gameIdx = gameIdx;
    }

}
