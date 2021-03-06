package dogood.hackathon.navi.domain.entity;

import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="main_recommand_contents" )
public class MainRecommandContentsEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="recommand_idx")
    private Long rcomIdx;

    @Column(name ="show_title", nullable = false)
    private String title;

    @Column(name ="show_description" , nullable = false)
    private String desc;

    @Column(name ="show_strt_dtm", nullable = false)
    private Timestamp strtDtm;

    @Column(name ="show_end_dtm", nullable = false)
    private Timestamp endDtm;

    @Column(name ="thumbnail_path", nullable = false)
    @Setter
    private String thumbNail;

    @Builder
    public MainRecommandContentsEntity(Long rcomIdx, String title, String desc, Timestamp strtDtm , Timestamp endDtm,String thumbNail) {
        this.rcomIdx = rcomIdx;
        this.title = title;
        this.desc = desc;
        this.strtDtm = strtDtm;
        this.endDtm = endDtm;
        this.thumbNail = thumbNail;
    }

}
