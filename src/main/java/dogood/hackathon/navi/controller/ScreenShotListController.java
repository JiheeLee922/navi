package dogood.hackathon.navi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dogood.hackathon.navi.service.ScreenShotService;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("screenShotList")
@RestController
@AllArgsConstructor
public class ScreenShotListController {

	private ScreenShotService screenShotService;
	
	@GetMapping("getList")
	@CrossOrigin("*")
	public List<Map<String,Object>> getList(String search, String searchWord, HttpServletRequest req){
		String domain = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort();
		List<Map<String,Object>> list = screenShotService.listScreenShot(search, searchWord);
		for(Map<String,Object> map : list){
			String thumbnailGame = domain + map.get("thumbnailGame").toString();
			String thumbnailScreenShot = domain + map.get("thumbnailScreenShot").toString();
			map.replace("thumbnailGame",thumbnailGame);
			map.replace("thumbnailScreenShot",thumbnailScreenShot);
		}
		return list;
	}
}
