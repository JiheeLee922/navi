package dogood.hackathon.navi.service;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dogood.hackathon.navi.domain.repository.SampleRepository;
import dogood.hackathon.navi.dto.SampleDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SampleService {
	private SampleRepository sampleRepository;
	
	@Transactional
	public Long savePost(SampleDto sampleDto) {
		return sampleRepository.save(sampleDto.toEntity()).getId();
	}
	
	
	
}
