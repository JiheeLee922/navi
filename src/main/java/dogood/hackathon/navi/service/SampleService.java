package dogood.hackathon.navi.service;

import dogood.hackathon.navi.domain.repository.SampleRepository;
import dogood.hackathon.navi.dto.SampleDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class SampleService {
	private SampleRepository sampleRepository;
	
	@Transactional
	public Long savePost(SampleDto sampleDto) {
		return sampleRepository.save(sampleDto.toEntity()).getId();
	}
}
