package dogood.hackathon.navi.domain.repository;

import dogood.hackathon.navi.domain.entity.MainRecommandContentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public interface MainRcomContentsRepository extends JpaRepository<MainRecommandContentsEntity, Long> {
    public MainRecommandContentsEntity findByStrtDtmLessThanEqualAndEndDtmGreaterThanEqualOrderByRcomIdxDesc(Timestamp sdtm,Timestamp edtm);


    @Query(value = "select mrc.* " +
            " from main_recommand_contents mrc" +
            " join main_recommand_game mrg" +
            " on mrc.recommand_idx = mrg.recommand_idx"
            , nativeQuery=true)
    public List<MainRecommandContentsEntity> list();

}
