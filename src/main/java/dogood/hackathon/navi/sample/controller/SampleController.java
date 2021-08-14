package dogood.hackathon.navi.sample.controller;

import dogood.hackathon.navi.sample.dto.SampleDto;
import dogood.hackathon.navi.sample.service.SampleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SampleController {
	private SampleService sampleService;

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
