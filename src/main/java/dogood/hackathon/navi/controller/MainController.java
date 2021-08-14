package dogood.hackathon.navi.controller;

import dogood.hackathon.navi.domain.entity.MainRecommandContentsEntity;
import dogood.hackathon.navi.service.MainService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainController {

    private MainService mainService;

    public MainRecommandContentsEntity main(){
        return mainService.getMain();
    }
}
