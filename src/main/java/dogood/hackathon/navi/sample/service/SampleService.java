package dogood.hackathon.navi.sample.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SampleService {
	private SampleRepository sampleRepository;
	
	@Transactional
	public Long savePost(SampleDto sampleDto) {
		return sampleRepository.save(sampleDto.toEntity()).getId();
	}
}
