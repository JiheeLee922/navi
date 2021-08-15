package dogood.hackathon.navi.util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(value="/upload")
public class FileUploadController {
    /*
        프로필
        스샷
        게임
     */

    @RequestMapping(value="/profile")
    public ResponseEntity prpfile(HttpServletRequest request){
        String resultCd = "F";
        String resultMsg = "잠시 후, 다시 시도해주세요.";
        String stackTrace = "";
        HttpSession session = request.getSession();
        try{
            String loginId = Optional.ofNullable(session.getAttribute("loginId").toString()).orElseThrow(()->new Exception("로그인을 해주세요."));
        }catch(Exception e){
            resultCd = "S";
            resultMsg = Optional.ofNullable(e.getMessage()).orElseGet(()->"잠시 후, 다시 시도해주세요.");
            stackTrace = e.getStackTrace().toString();
        }
        return null;
    }
}
