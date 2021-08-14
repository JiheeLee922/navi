package dogood.hackathon.navi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dogood.hackathon.navi.domain.entity.MainRecommandContentsEntity;
import dogood.hackathon.navi.dto.ScreenShotDto;
import dogood.hackathon.navi.service.MainService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private MainService mainService;

    @GetMapping("/main")
    @CrossOrigin("*")
    public MainRecommandContentsEntity main(){
        return mainService.getMain();
    }

    
    @GetMapping("rnbRanking")
    public List<ScreenShotDto> listRnbRanking(){
    	
    	return mainService.listRnbRanking();
    }

    @GetMapping("/test")
    @CrossOrigin("*")
    public List<MainRecommandContentsEntity> test(){
        return mainService.list();
    }
}
