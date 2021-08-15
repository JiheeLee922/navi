package dogood.hackathon.navi.service;

import dogood.hackathon.navi.domain.entity.GameInfoEntity;
import dogood.hackathon.navi.domain.entity.MainRecommandContentsEntity;
import dogood.hackathon.navi.domain.entity.ScreenShotEntity;
import dogood.hackathon.navi.domain.repository.GameInfoRepository;
import dogood.hackathon.navi.domain.repository.MainRepository;
import dogood.hackathon.navi.domain.repository.ScreenShotRepository;
import dogood.hackathon.navi.dto.ScreenShotDto;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MainService {
    private MainRepository mainRepository;

    private GameInfoRepository gameInfoRepository;

    private ScreenShotRepository screenShotRepository;

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
    public List<GameInfoEntity> getMainGameList(Long rcomIdx) throws Exception{
        return gameInfoRepository.getMainGameList(rcomIdx);
    }
    
    @Transactional
    public List<ScreenShotDto> listRnbRanking(){
    	
    	List<ScreenShotEntity> testEntites = screenShotRepository.rnbList();
		List<ScreenShotDto> testDtoList = new ArrayList<>();
		
		testEntites.forEach(testEntity ->{
			ScreenShotDto testDto = ScreenShotDto.builder()
					.screenShotIdx(testEntity.getScreen_shot_idx())
					.thumbnailPath(testEntity.getThumbnail_path())
					.position(testEntity.getPosition())
					.gameNm(testEntity.getGame_nm())
					.build(); 
			
			testDtoList.add(testDto);
			
		});
    	return testDtoList;
    }

}
