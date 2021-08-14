package dogood.hackathon.navi.dto;

import java.time.LocalDateTime;

import dogood.hackathon.navi.domain.entity.SampleEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SampleDto {

	private Long id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    
    public SampleEntity toEntity() {
    	SampleEntity sampleEntity = SampleEntity.builder()
    			.id(id)
    			.writer(writer)
    			.title(title)
    			.content(content)
    			.build();
    	return sampleEntity;
    }
    
    @Builder
    public SampleDto(Long id, String title, String content, String writer, LocalDateTime createdDate, LocalDateTime modifiedDate) {
    	this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;		
    }
}
