package dogood.hackathon.navi.domain.entity;

import com.sun.istack.Nullable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="MAIN_RECOMMAND_CONTENTS")
public class MainRecommandContentsEntity extends TimeEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(columnDefinition="RECOMMAND_IDX")
    private Long rcomIdx;

    @Column(columnDefinition ="SHOW_TITLE", nullable = false)
    private String title;

    @Column(columnDefinition ="SHOW_DESCRIPTION" , nullable = false)
    private String desc;

    @Column(columnDefinition = "SHOW_STRT_DTM", nullable = false)
    private Timestamp strtDtm;

    @Column(columnDefinition = "SHOW_END_DTM", nullable = false)
    private Timestamp endDtm;

    private Timestamp searchTime;

    @Builder
    public MainRecommandContentsEntity(Long rcomIdx, String title, String desc, Timestamp strtDtm , Timestamp endDtm , @Nullable Timestamp searchTime) {
        this.rcomIdx = rcomIdx;
        this.title = title;
        this.desc = desc;
        this.strtDtm = strtDtm;
        this.endDtm = endDtm;
        this.searchTime = searchTime;
    }
}
