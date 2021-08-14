package dogood.hackathon.navi.controller;

import dogood.hackathon.navi.domain.entity.MainRecommandContentsEntity;
import dogood.hackathon.navi.dto.SampleDto;
import dogood.hackathon.navi.service.MainService;
import dogood.hackathon.navi.service.SampleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SampleController {
	private SampleService sampleService;

	private MainService mainService;

	@GetMapping("/list")
	public String list() {
		
		return "list";
	}
	
	@GetMapping("/post")
    public String write() {
        return "write"; 
    }

	@PostMapping("/post")
	public String write(SampleDto sampleDto) {
		sampleService.savePost(sampleDto);
		return "redirect:/"; 
	}
}
