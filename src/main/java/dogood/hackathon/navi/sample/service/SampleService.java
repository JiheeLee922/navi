package dogood.hackathon.navi.sample.service;

import javax.transaction.Transactional;

import dogood.hackathon.navi.sample.domain.repository.SampleRepository;
import dogood.hackathon.navi.sample.dto.SampleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SampleService {
	@Autowired
	private SampleRepository sampleRepository;
	
	@Transactional
	public Long savePost(SampleDto sampleDto) {
		return sampleRepository.save(sampleDto.toEntity()).getId();
	}
}
