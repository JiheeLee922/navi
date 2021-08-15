package dogood.hackathon.navi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dogood.hackathon.navi.dto.ScreenShotDto;
import dogood.hackathon.navi.dto.ScreenShotImgDto;
import dogood.hackathon.navi.service.ScreenShotService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("screenShot")
@AllArgsConstructor
@Slf4j
public class ScreenShotDetailController {

	private ScreenShotService screenShotDetailService;
	
	@GetMapping("/getInfo")
	@CrossOrigin("*")
	public Map<String,Object> getScreenShotDetail(ScreenShotDto dto) {
		
		Map<String,Object> map = new HashMap<>();
		
		ScreenShotDto shotInfo = screenShotDetailService.getScreenShotDetail(dto);
		map.put("info", shotInfo);
		map.put("comment", screenShotDetailService.listShotCommentById(dto));
		 
		map.put("recommend",  screenShotDetailService.listRecommendGame(shotInfo.getTag(), dto.getScreenShotIdx()));
		return map;
	}
	
	@GetMapping("/getToonsInfo")
	@CrossOrigin("*")
	public List<ScreenShotImgDto> listScreenShotForToons(ScreenShotDto dto){
		return screenShotDetailService.listScreenShotForToons(dto);
	}
}
