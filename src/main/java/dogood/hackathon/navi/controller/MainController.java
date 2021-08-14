package dogood.hackathon.navi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dogood.hackathon.navi.domain.entity.MainRecommandContentsEntity;
import dogood.hackathon.navi.dto.ScreenShotDto;
import dogood.hackathon.navi.service.MainService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MainController {

    private MainService mainService;

    @GetMapping("/main")
    @CrossOrigin("*")
    public MainRecommandContentsEntity main(){
        return mainService.getMain();
    }

    
    @GetMapping("/main/rnbRanking")
    @CrossOrigin("*")
    public List<ScreenShotDto> listRnbRanking(){
    	
    	return mainService.listRnbRanking();
    }

    @GetMapping("/test")
    @CrossOrigin("*")
    public List<MainRecommandContentsEntity> test(){
        return mainService.list();
    }
}
