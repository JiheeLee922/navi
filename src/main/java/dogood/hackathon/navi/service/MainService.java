package dogood.hackathon.navi.service;

import dogood.hackathon.navi.domain.entity.MainRecommandContentsEntity;
import dogood.hackathon.navi.domain.repository.MainRcomContentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;

@Service
@AllArgsConstructor
public class MainService {
    private MainRcomContentsRepository mainRcomContentsRepository;

    @Transactional
    public MainRecommandContentsEntity getMain(){
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        return mainRcomContentsRepository.findBy(currentTime);
    }

}
