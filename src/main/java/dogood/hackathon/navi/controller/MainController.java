package dogood.hackathon.navi.controller;

import dogood.hackathon.navi.domain.entity.GameInfoEntity;
import dogood.hackathon.navi.domain.entity.MainRecommandContentsEntity;
import dogood.hackathon.navi.domain.entity.UserInfoEntity;
import dogood.hackathon.navi.service.MainService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private MainService mainService;

    @GetMapping("/main")
    @CrossOrigin("*")
    public ResponseEntity main(HttpServletRequest req){
        String resultCd = "S";
        HashMap<String,Object> body = new HashMap<String,Object>();
        String domain = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort();

        try{
            //메인 게임
            MainRecommandContentsEntity mainContents = mainService.getMainContents();
            mainContents.setThumbNail(domain + mainContents.getThumbNail());
            //태그 리스트
            List<String> tag = mainService.getMainTag(mainContents.getRcomIdx());
            //게임 리스트
            List<GameInfoEntity> list = mainService.getMainGameList(mainContents.getRcomIdx());
            for(GameInfoEntity game : list){
                game.setThumbNail(domain+game.getThumbNail());
            }

            //유저 정보
            UserInfoEntity user = mainService.getUserProfile("navi_id");
            user.setPrflImgPath(domain + user.getPrflImgPath());

            body.put("user",user);
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
