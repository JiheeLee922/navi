package dogood.hackathon.navi.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dogood.hackathon.navi.domain.entity.MainRecommandContentsEntity;
import dogood.hackathon.navi.domain.entity.ScreenShotEntity;
import dogood.hackathon.navi.domain.repository.MainRcomContentsRepository;
import dogood.hackathon.navi.domain.repository.ScreenShotRepository;
import dogood.hackathon.navi.dto.ScreenShotDto;
import lombok.AllArgsConstructor;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
@AllArgsConstructor
public class MainService {
    private MainRcomContentsRepository mainRcomContentsRepository;
    private ScreenShotRepository screenShotRepository;
    

    @Transactional
    public MainRecommandContentsEntity getMain(){
        Timestamp today = new Timestamp(System.currentTimeMillis());
        return mainRcomContentsRepository.findByStrtDtmLessThanEqualAndEndDtmGreaterThanEqualOrderByRcomIdxDesc(today,today);
    }

    @Transactional
    public List<MainRecommandContentsEntity> list(){
        return mainRcomContentsRepository.list();
    }
    
    @Transactional
    public List<ScreenShotDto> listRnbRanking(){
    	
    	List<ScreenShotEntity> testEntites = screenShotRepository.findAll();
		List<ScreenShotDto> testDtoList = new ArrayList<>();
		
		testEntites.forEach(testEntity ->{
			ScreenShotDto testDto = ScreenShotDto.builder()
					.screenShotIdx(testEntity.getScreen_shot_idx())
					.gameIdx(testEntity.getGame_idx())
					.userIdx(testEntity.getUser_idx())
					.build();
			
			testDtoList.add(testDto);
			
		});
    	return testDtoList;
    }

}
