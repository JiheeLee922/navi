package dogood.hackathon.navi.controller;

import dogood.hackathon.navi.domain.entity.UserInfoEntity;
import dogood.hackathon.navi.dto.UserInfoDto;
import dogood.hackathon.navi.service.UserService;
import io.netty.util.internal.StringUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Optional;
import java.util.regex.Pattern;

@Slf4j
@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @CrossOrigin("*")
    @PostMapping(value="/join")
    public ResponseEntity join(UserInfoDto dto){
        String resultMsg = "";
        Boolean isOk = true;
        String loginId = dto.getLoginId();
        String nickNm = dto.getNickNm();
        String prflImgPath = dto.getPrflImgPath();

        log.info("### join start ###");
        log.info("### loginId : {} ###",loginId);
        log.info("### nickNm : {} ###",nickNm);
        try{
            String loginId_regExp = "[a-zA-Z | 0-9]*";
            String nickNm_regExp = "[ㄱ-힣|a-zA-Z|0-9]*";

            if(StringUtil.isNullOrEmpty(loginId) || !Pattern.matches(loginId_regExp, loginId)){
                throw new Exception("아이디를 다시 입력해주세요.");
            }
            if(StringUtil.isNullOrEmpty(nickNm) || !Pattern.matches(nickNm_regExp, nickNm)){
                throw new Exception("닉네임을 다시 입력해주세요");
            }

            UserInfoEntity result = userService.join(loginId,nickNm, Optional.ofNullable(prflImgPath).orElse(null));
            return new ResponseEntity<UserInfoEntity>(result,HttpStatus.OK);
        }catch(Exception e){
            HashMap<String,String> body = new HashMap<String,String>();
            body.put("resultCd","F");
            body.put("resultMsg",e.getMessage());
            return new ResponseEntity<HashMap<String,String>>(body,HttpStatus.NOT_FOUND);
        }

    }

    @CrossOrigin("*")
    @PostMapping(value="/login")
    public ResponseEntity login(String loginId, HttpServletRequest request){
        try{
            loginId = Optional.ofNullable(loginId).orElseThrow(()->new Exception("아이디를 확인해주세요."));
            UserInfoEntity result = userService.login(loginId);

            HttpSession session = request.getSession();
            session.setAttribute("loginId",loginId);
            session.setAttribute("nickNm",result.getNickNm());

            return new ResponseEntity<UserInfoEntity>(result,HttpStatus.OK);
        }catch(Exception e){
            HashMap<String,String> body = new HashMap<String,String>();
            body.put("resultCd","F");
            body.put("resultMsg",e.getMessage());
            return new ResponseEntity<HashMap<String,String>>(body,HttpStatus.NOT_FOUND);
        }
    }
}
