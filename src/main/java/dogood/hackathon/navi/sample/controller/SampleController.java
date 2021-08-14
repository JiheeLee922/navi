package dogood.hackathon.navi.sample.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;

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
