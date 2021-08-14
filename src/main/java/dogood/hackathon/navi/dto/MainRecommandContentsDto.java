package dogood.hackathon.navi.dto;


import com.sun.istack.Nullable;
import dogood.hackathon.navi.domain.entity.MainRecommandContentsEntity;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MainRecommandContentsDto {

    private Long rcomIdx;
    private String title;
    private String desc;
    private Timestamp strtDtm;
    private Timestamp endDtm;

    public MainRecommandContentsEntity toEntity(){
        MainRecommandContentsEntity entity = MainRecommandContentsEntity.builder()
                .rcomIdx(rcomIdx)
                .title(title)
                .desc(desc)
                .strtDtm(strtDtm)
                .endDtm(endDtm)
                .build();
        return entity;
    }

    @Builder
    public MainRecommandContentsDto(Long rcomIdx, String title, String desc, Timestamp strtDtm , Timestamp endDtm) {
        this.rcomIdx = rcomIdx;
        this.title = title;
        this.desc = desc;
        this.strtDtm = strtDtm;
        this.endDtm = endDtm;
    }
}
