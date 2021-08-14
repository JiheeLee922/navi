package dogood.hackathon.navi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dogood.hackathon.navi.service.ScreenShotService;
import lombok.AllArgsConstructor;

@RequestMapping("screenShotList")
@RestController
@AllArgsConstructor
public class ScreenShotListController {

	private ScreenShotService screenShotService;
	
	@GetMapping("getList")
	@CrossOrigin("*")
	public List<Map<String,Object>> getList(String search, String searchWord){
		return screenShotService.listScreenShot(search, searchWord);
	}
}
