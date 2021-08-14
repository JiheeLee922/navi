package dogood.hackathon.navi.controller;

import dogood.hackathon.navi.domain.entity.GameInfoEntity;
import dogood.hackathon.navi.domain.entity.MainRecommandContentsEntity;
import dogood.hackathon.navi.service.MainService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private MainService mainService;

    @GetMapping("/main")
    @CrossOrigin("*")
    public ResponseEntity main(){
        String resultCd = "S";
        HashMap<String,Object> body = new HashMap<String,Object>();

        try{
            //메인 게임
            MainRecommandContentsEntity mainContents = mainService.getMainContents();
            //태그 리스트
            List<String> tag = mainService.getMainTag(mainContents.getRcomIdx());
            //게임 리스트
            List<GameInfoEntity> list = mainService.getMainGameList(mainContents.getRcomIdx());
            body.put("resultCd",resultCd);
            body.put("main",mainContents);
            body.put("tag",tag);
            body.put("list",list);
            return new ResponseEntity<>(body, HttpStatus.OK);
        }catch(Exception e){
            resultCd = "F";
            body.put("title","보다 나은 서비스를 위해 준비중입니다.");
            body.put("resultCd",resultCd);
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
    }

}
