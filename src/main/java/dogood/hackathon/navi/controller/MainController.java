package dogood.hackathon.navi.controller;

import dogood.hackathon.navi.domain.entity.MainRecommandContentsEntity;
import dogood.hackathon.navi.domain.entity.UserInfoEntity;
import dogood.hackathon.navi.service.MainService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainController {

    private MainService mainService;

    @GetMapping("/main")
    @CrossOrigin("*")
    public MainRecommandContentsEntity main(){
        return mainService.getMain();
    }

}
