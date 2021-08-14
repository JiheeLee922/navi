package dogood.hackathon.navi.service;

import dogood.hackathon.navi.domain.entity.GameInfoEntity;
import dogood.hackathon.navi.domain.entity.MainRecommandContentsEntity;
import dogood.hackathon.navi.domain.repository.GameInfoRepository;
import dogood.hackathon.navi.domain.repository.MainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
@AllArgsConstructor
public class MainService {
    private MainRepository mainRepository;

    private GameInfoRepository gameInfoRepository;

    @Transactional
    public MainRecommandContentsEntity getMainContents(){
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        return mainRepository.getMainContents(currentTime);
    }

    @Transactional
    public List<String> getMainTag(Long rcomIdx){
        return mainRepository.getMainTag(rcomIdx);
    }

    @Transactional
    public List<GameInfoEntity> getMainGameList(Long rcomIdx){
        return gameInfoRepository.getMainGameList(rcomIdx);
    }

}
