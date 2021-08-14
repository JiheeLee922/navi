package dogood.hackathon.navi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dogood.hackathon.navi.domain.entity.MainRecommandContentsEntity;
import dogood.hackathon.navi.dto.ScreenShotDto;
import dogood.hackathon.navi.service.MainService;
import lombok.AllArgsConstructor;

@RestController(value = "main")
@AllArgsConstructor
public class MainController {

    private MainService mainService;

    public MainRecommandContentsEntity main(){
        return mainService.getMain();
    }
    
    @GetMapping("rnbRanking")
    public List<ScreenShotDto> listRnbRanking(){
    	
    	return mainService.listRnbRanking();
    }
}
