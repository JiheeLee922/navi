package dogood.hackathon.navi.dto;


import dogood.hackathon.navi.domain.entity.MainRecommandContentsEntity;
import lombok.*;

import java.sql.Time;
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
    private Timestamp searchTime;

    public MainRecommandContentsEntity toEntity(){
        MainRecommandContentsEntity entity = MainRecommandContentsEntity.builder()
                .rcomIdx(rcomIdx)
                .title(title)
                .desc(desc)
                .strtDtm(strtDtm)
                .endDtm(endDtm)
                .searchTime(searchTime)
                .build();
        return entity;
    }

    @Builder
    public MainRecommandContentsDto(Long rcomIdx, String title, String desc, Timestamp strtDtm , Timestamp endDtm, Timestamp searchTime) {
        this.rcomIdx = rcomIdx;
        this.title = title;
        this.desc = desc;
        this.strtDtm = strtDtm;
        this.endDtm = endDtm;
        this.searchTime = searchTime;
    }
}
